package com.commerceimport.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.util.StringUtils;

import com.commercebase.services.ModelService;
import com.commerceimport.service.CommerceImportService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommerceImportServiceImpl implements CommerceImportService
{
	private ModelService modelService;
	@SuppressWarnings({ "null", "unchecked" })
	public void importData(String fileName) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, JSONException 
	{
		LineIterator lineIterator = FileUtils.lineIterator(new File(fileName), "UTF-8");
		try
		{
			Map<String, String> coulumnValues= new HashMap<String, String>();
			while(lineIterator.hasNext())
			{
				int count=1;
				String line= lineIterator.next();
				String[] columns = null;
				if(!StringUtils.isEmpty(line) && line.contains("!"))
				{
					columns=line.split(";");
					coulumnValues.put(String.valueOf(count), columns[count]);
					
				}
				else if(!StringUtils.isEmpty(line))
				{
					String[] types=columns[0].split("-");
					@SuppressWarnings("rawtypes")
					Class classinstance = Class.forName(types[1]);
					JSONObject json = new JSONObject();
					for(int column=1;column<=count;column++)
					{
						json.put(coulumnValues.get(column), columns[column]);
					}
					ObjectMapper objectMapper= new ObjectMapper();
					modelService.saveModel(objectMapper.readValue(json.toString(),  classinstance));
				}
			}
		}
		finally
		{
			lineIterator.close();
		}
		
			
	}

}
