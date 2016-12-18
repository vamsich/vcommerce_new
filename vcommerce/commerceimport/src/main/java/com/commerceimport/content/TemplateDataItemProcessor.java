package com.commerceimport.content;

import org.springframework.batch.item.ItemProcessor;

import com.commercecontent.model.PageTemplateModel;

public class TemplateDataItemProcessor implements ItemProcessor<PageTemplateModel, PageTemplateModel>
{

	public PageTemplateModel process(PageTemplateModel pageTemplateModel) throws Exception 
	{
		return pageTemplateModel;
	}
	
}
