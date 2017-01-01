package com.commercefacades.converters.impl;

import com.commercebase.content.data.PageTemplateData;
import com.commercecontent.model.PageTemplateModel;
import com.commercefacades.converters.Populator;

public class PageTemplatePopulator implements Populator<PageTemplateModel, PageTemplateData>
{

	public PageTemplateData populate(PageTemplateModel source, PageTemplateData target) 
	{
		target.setCode(source.getCode());
		target.setFrontPageName(source.getFrontPageName());
		target.setName(source.getName());
		return target;
	}

}
