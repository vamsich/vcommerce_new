package com.commerceimport.batch.custom;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ReaderNotOpenException;
import org.springframework.batch.item.file.BufferedReaderFactory;
import org.springframework.batch.item.file.DefaultBufferedReaderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.LineCallbackHandler;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.NonTransientFlatFileException;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.batch.item.file.separator.RecordSeparatorPolicy;
import org.springframework.batch.item.file.separator.SimpleRecordSeparatorPolicy;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

public class CommerceFlatFileItemReader<T> extends AbstractItemCountingItemStreamItemReader<T>
implements ResourceAwareItemReaderItemStream<T>, InitializingBean 
{
	private static final Log logger = LogFactory.getLog(FlatFileItemReader.class);

	public static final String DEFAULT_CHARSET = Charset.defaultCharset().name();

	private RecordSeparatorPolicy recordSeparatorPolicy = new SimpleRecordSeparatorPolicy();
	private Resource resource;
	private BufferedReader reader;
	private int lineCount = 0;

	private String[] comments = { "#" };

	private boolean noInput = false;

	private String encoding = DEFAULT_CHARSET;
	private LineMapper<T> lineMapper;
	private int linesToSkip = 0;
	private LineCallbackHandler skippedLinesCallback;
	private boolean strict = true;

	private BufferedReaderFactory bufferedReaderFactory = new DefaultBufferedReaderFactory();

	public CommerceFlatFileItemReader() {
		setName(ClassUtils.getShortName(CommerceFlatFileItemReader.class));
	}

	public void setStrict(boolean strict) {
		this.strict = strict;
	}

	public void setSkippedLinesCallback(LineCallbackHandler skippedLinesCallback) {
		this.skippedLinesCallback = skippedLinesCallback;
	}

	public void setLinesToSkip(int linesToSkip) {
		this.linesToSkip = linesToSkip;
	}

	public void setLineMapper(LineMapper<T> lineMapper) {
		this.lineMapper = lineMapper;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void setBufferedReaderFactory(BufferedReaderFactory bufferedReaderFactory) {
		this.bufferedReaderFactory = bufferedReaderFactory;
	}

	public void setComments(String[] comments) {
		this.comments = new String[comments.length];
		System.arraycopy(comments, 0, this.comments, 0, comments.length);
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void setRecordSeparatorPolicy(RecordSeparatorPolicy recordSeparatorPolicy) {
		this.recordSeparatorPolicy = recordSeparatorPolicy;
	}

	protected T doRead() throws Exception {
		if (this.noInput) {
			return null;
		}

		String line = readLine();

		if (line == null | line.startsWith("INSERT")) {
			return null;
		}
		try {
			return this.lineMapper.mapLine(line, this.lineCount);
		} catch (Exception ex) {
			throw new FlatFileParseException("Parsing error at line: " + this.lineCount + " in resource=["
					+ this.resource.getDescription() + "], input=[" + line + "]", ex, line, this.lineCount);
		}
	}

	private String readLine() {
		if (this.reader == null) {
			throw new ReaderNotOpenException("Reader must be open before it can be read.");
		}

		String line = null;
		try {
			line = this.reader.readLine();
			if (line == null) {
				return null;
			}
			this.lineCount += 1;
			while (isComment(line)) {
				line = this.reader.readLine();
				if (line == null) {
					return null;
				}
				this.lineCount += 1;
			}

			line = applyRecordSeparatorPolicy(line);
		} catch (IOException e) {
			this.noInput = true;
			throw new NonTransientFlatFileException("Unable to read from resource: [" + this.resource + "]", e, line,
					this.lineCount);
		}

		return line;
	}

	private boolean isComment(String line) {
		for (String prefix : this.comments) {
			if (line.startsWith(prefix)) {
				return true;
			}
		}
		return false;
	}

	protected void doClose() throws Exception {
		this.lineCount = 0;
		if (this.reader != null)
			this.reader.close();
	}

	protected void doOpen() throws Exception {
		Assert.notNull(this.resource, "Input resource must be set");
		Assert.notNull(this.recordSeparatorPolicy, "RecordSeparatorPolicy must be set");

		this.noInput = true;
		if (!(this.resource.exists())) {
			if (this.strict) {
				throw new IllegalStateException(
						"Input resource must exist (reader is in 'strict' mode): " + this.resource);
			}
			logger.warn("Input resource does not exist " + this.resource.getDescription());
			return;
		}

		if (!(this.resource.isReadable())) {
			if (this.strict) {
				throw new IllegalStateException(
						"Input resource must be readable (reader is in 'strict' mode): " + this.resource);
			}

			logger.warn("Input resource is not readable " + this.resource.getDescription());
			return;
		}

		this.reader = this.bufferedReaderFactory.create(this.resource, this.encoding);
		for (int i = 0; i < this.linesToSkip; ++i) {
			String line = readLine();
			if (this.skippedLinesCallback != null) {
				this.skippedLinesCallback.handleLine(line);
			}
		}
		this.noInput = false;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.lineMapper, "LineMapper is required");
	}

	protected void jumpToItem(int itemIndex) throws Exception {
		for (int i = 0; i < itemIndex; ++i)
			readLine();
	}

	private String applyRecordSeparatorPolicy(String line) throws IOException {
		String record = line;
		while ((line != null) && (!(this.recordSeparatorPolicy.isEndOfRecord(record)))) {
			line = this.reader.readLine();
			if (line == null) {
				if (!(StringUtils.hasText(record))) {
					break;
				}
				throw new FlatFileParseException("Unexpected end of file before record complete", record,
						this.lineCount);
			}

			this.lineCount += 1;

			record = this.recordSeparatorPolicy.preProcess(record) + line;
		}

		return this.recordSeparatorPolicy.postProcess(record);
	}
}
