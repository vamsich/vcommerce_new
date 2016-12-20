package com.commercefacades.converters.impl;

import com.commercecontent.model.ContentPageModel;
import com.commercecontent.model.PageTemplateModel;
import com.commercefacades.converters.Populator;
import com.commercefacades.data.ContentPageData;

public class ContentPagePopulator implements Populator<ContentPageModel, ContentPageData>
{

	public ContentPageData populate(ContentPageModel source, ContentPageData target) 
	{
		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setPageName(source.getPageName());
		PageTemplateModel pageTemplate=source.getPageTemplate();
		if(source.getPageTemplate()!=null)
		{
			String label=pageTemplate.getFrontPageName();
			target.setLabel(label);
		}
		
		return target;
	}
	
}
