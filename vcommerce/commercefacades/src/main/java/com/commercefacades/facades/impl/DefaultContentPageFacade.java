package com.commercefacades.facades.impl;

import com.commercecontent.model.ContentPageModel;
import com.commercecontent.model.PageTemplateModel;
import com.commercecontent.service.ContentPageService;
import com.commercecontent.service.PageTemplateService;
import com.commercefacades.converters.Converters;
import com.commercefacades.data.ContentPageData;
import com.commercefacades.facades.ContentPageFacade;

public class DefaultContentPageFacade implements ContentPageFacade
{
	private ContentPageService contentPageService;
	
	private PageTemplateService pageTemplateService;
	
	public PageTemplateService getPageTemplateService() {
		return pageTemplateService;
	}

	public void setPageTemplateService(PageTemplateService pageTemplateService) {
		this.pageTemplateService = pageTemplateService;
	}

	public ContentPageService getContentPageService() {
		return contentPageService;
	}

	public void setContentPageService(ContentPageService contentPageService) {
		this.contentPageService = contentPageService;
	}

	private Converters<ContentPageModel, ContentPageData> contentPageConverter;
	
	public Converters<ContentPageModel, ContentPageData> getContentPageConverter() {
		return contentPageConverter;
	}

	public void setContentPageConverter(Converters<ContentPageModel, ContentPageData> contentPageConverter) {
		this.contentPageConverter = contentPageConverter;
	}

	public ContentPageData getSite(int id) 
	{
		return contentPageConverter.convert(contentPageService.getModel(id));
	}

	public void save(ContentPageData contentPage) 
	{
		ContentPageModel contentPageModel= new ContentPageModel();
		contentPageModel.setCode(contentPage.getCode());
		contentPageModel.setName(contentPage.getName());
		contentPageModel.setPageName(contentPage.getName());
		PageTemplateModel pageTemplateModel=pageTemplateService.getTemplate(contentPage.getPageTemplate());
		contentPageModel.setPageTemplate(pageTemplateModel);
		contentPageService.saveModel(contentPageModel);
	}

	public ContentPageData getContentPage(String code) 
	{
		ContentPageModel contentPageModel=contentPageService.getContentPage(code);
		return contentPageConverter.convert(contentPageModel);
	}
	
}
