package com.commercefacades.facades.impl;

import java.util.ArrayList;
import java.util.List;

import com.commercebase.content.data.PageTemplateData;
import com.commercecontent.model.PageTemplateModel;
import com.commercecontent.service.PageTemplateService;
import com.commercefacades.converters.Converters;
import com.commercefacades.facades.PageTemplateFacade;

public class DefaultPageTemplateFacade implements PageTemplateFacade
{
	private PageTemplateService pageTemplateService;

	private Converters<PageTemplateModel, PageTemplateData> pageTemplateConverter;
	
	public Converters<PageTemplateModel, PageTemplateData> getPageTemplateConverter() {
		return pageTemplateConverter;
	}

	public void setPageTemplateConverter(Converters<PageTemplateModel, PageTemplateData> pageTemplateConverter) {
		this.pageTemplateConverter = pageTemplateConverter;
	}

	public PageTemplateService getPageTemplateService() {
		return pageTemplateService;
	}

	public void setPageTemplateService(PageTemplateService pageTemplateService) {
		this.pageTemplateService = pageTemplateService;
	}

	public PageTemplateData getModel(int id) 
	{
		return pageTemplateConverter.convert(pageTemplateService.getModel(id));
	}

	public void saveModel(PageTemplateData pageTemplate) 
	{
		PageTemplateModel pageTemplateModel= new PageTemplateModel();
		pageTemplateModel.setName(pageTemplate.getName());
		pageTemplateModel.setFrontPageName(pageTemplate.getFrontPageName());
		pageTemplateModel.setCode(pageTemplate.getCode());
		pageTemplateService.saveModel(pageTemplateModel);
	}

	public void updateModel(PageTemplateData pageTemplate) 
	{
		PageTemplateModel pageTemplateModel= new PageTemplateModel();
		pageTemplateModel.setName(pageTemplate.getName());
		pageTemplateModel.setFrontPageName(pageTemplate.getFrontPageName());
		pageTemplateModel.setCode(pageTemplate.getCode());
		pageTemplateService.saveModel(pageTemplateModel);
	}

	public void deleteModel(PageTemplateData pageTemplate) 
	{
		//
	}

	public List<PageTemplateData> getModels() 
	{
		List<PageTemplateData> pageTemplates= new ArrayList<PageTemplateData>();
		for(PageTemplateModel pageTemplateModel: pageTemplateService.getModels())
		{
			pageTemplates.add(pageTemplateConverter.convert(pageTemplateModel));
		}
		return pageTemplates;
	}
}
