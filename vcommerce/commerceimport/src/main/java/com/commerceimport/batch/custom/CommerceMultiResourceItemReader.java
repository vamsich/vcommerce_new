package com.commerceimport.batch.custom;

import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.ResourceAware;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.batch.item.support.AbstractItemStreamItemReader;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

public class CommerceMultiResourceItemReader <T> extends AbstractItemStreamItemReader<T>
{
	private static final Log logger = LogFactory.getLog(CommerceMultiResourceItemReader.class);
	private static final String RESOURCE_KEY = "resourceIndex";
	private ResourceAwareItemReaderItemStream<? extends T> delegate;
	private Resource[] resources;
	private boolean saveState = true;

	private int currentResource = -1;
	private boolean noInput;
	private boolean strict = false;
	
	public void setStrict(boolean strict) {
		this.strict = strict;
	}
	
	public CommerceMultiResourceItemReader() {
		setExecutionContextName(ClassUtils.getShortName(CommerceMultiResourceItemReader.class));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Comparator<Resource> comparator = new Comparator() 
	{
		public int compare(Object o1, Object o2) 
		{
			Resource r1 = null;
			Resource r2 = null;
			if(o1 instanceof Resource)
			{
				r1= (Resource) o1;
			}
			if(o2 instanceof Resource)
			{
				r2= (Resource) o2;
			}
			return r1.getFilename().compareTo(r2.getFilename());
		}
	};
	
	public void setComparator(Comparator<Resource> comparator) {
		this.comparator = comparator;
	}
	
	public ResourceAwareItemReaderItemStream<? extends T> getDelegate() {
		return delegate;
	}


	public void setDelegate(ResourceAwareItemReaderItemStream<? extends T> delegate) {
		this.delegate = delegate;
	}


	public Resource[] getResources() {
		return resources;
	}


	public void setResources(Resource[] resources) 
	{
		Assert.notNull(resources, "The resources must not be null");
		this.resources = ((Resource[]) Arrays.asList(resources).toArray(new Resource[resources.length]));
	}


	public Resource getCurrentResource() 
	{
		if ((this.currentResource >= this.resources.length) || (this.currentResource < 0)) {
			return null;
		}
		return this.resources[this.currentResource];
	}

	public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException 
	{

		if (this.noInput) {
			return null;
		}

		if (this.currentResource == -1) {
			this.currentResource = 0;
			this.delegate.setResource(this.resources[this.currentResource]);
			this.delegate.open(new ExecutionContext());
		}

		return readNextItem();
	}
	
	private T readNextItem() throws Exception {
		Object item = readFromDelegate();

		while (item == null) {
			this.currentResource += 1;

			if (this.currentResource >= this.resources.length) {
				return null;
			}

			this.delegate.close();
			this.delegate.setResource(this.resources[this.currentResource]);
			this.delegate.open(new ExecutionContext());

			item = readFromDelegate();
		}

		return (T) item;
	}
	
	private T readFromDelegate() throws Exception {
		Object item = this.delegate.read();
		if (item instanceof ResourceAware) {
			((ResourceAware) item).setResource(getCurrentResource());
		}
		return (T) item;
	}
	
	public void close() throws ItemStreamException {
		super.close();
		this.delegate.close();
		this.noInput = false;
	}
	
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		super.open(executionContext);
		Assert.notNull(this.resources, "Resources must be set");

		this.noInput = false;
		if (this.resources.length == 0) {
			if (this.strict) {
				throw new IllegalStateException(
						"No resources to read. Set strict=false if this is not an error condition.");
			}

			logger.warn("No resources to read. Set strict=true if this should be an error condition.");
			this.noInput = true;
			return;
		}

		Arrays.sort(this.resources, this.comparator);

		if (executionContext.containsKey(getExecutionContextKey("resourceIndex"))) {
			this.currentResource = executionContext.getInt(getExecutionContextKey("resourceIndex"));

			if (this.currentResource == -1) {
				this.currentResource = 0;
			}

			this.delegate.setResource(this.resources[this.currentResource]);
			this.delegate.open(executionContext);
		} else {
			this.currentResource = -1;
		}
	}
	
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		super.update(executionContext);
		if (this.saveState) {
			executionContext.putInt(getExecutionContextKey("resourceIndex"), this.currentResource);
			this.delegate.update(executionContext);
		}
	}
}
