package com.commercefacades.facades.impl;

import com.commercecontent.model.ContentPageModel;
import com.commercecontent.service.ContentPageService;
import com.commercefacades.converters.Converters;
import com.commercefacades.data.ContentPageData;
import com.commercefacades.facades.ContentPageFacade;

public class DefaultContentPageFacade implements ContentPageFacade
{
	private ContentPageService contentPageService;
	
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
		contentPageModel.setLabel(contentPage.getName());
		contentPageModel.setName(contentPage.getName());
		contentPageModel.setPageName(contentPage.getName());
		contentPageService.saveModel(contentPageModel);
	}
	
}
