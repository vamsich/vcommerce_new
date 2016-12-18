package com.commercefacades.converters.impl;

import com.commercecontent.model.ContentPageModel;
import com.commercefacades.converters.Populator;
import com.commercefacades.data.ContentPageData;

public class ContentPagePopulator implements Populator<ContentPageModel, ContentPageData>
{

	public ContentPageData populate(ContentPageModel source, ContentPageData target) 
	{
		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setPageName(source.getPageName());
		return target;
	}
	
}
