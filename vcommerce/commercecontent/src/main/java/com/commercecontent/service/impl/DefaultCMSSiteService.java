package com.commercecontent.service.impl;

import java.util.List;

import com.commercecontent.dao.ContentPageDao;
import com.commercecontent.model.ContentPageModel;
import com.commercecontent.service.CMSSiteService;

public class DefaultCMSSiteService implements CMSSiteService
{
	private ContentPageDao contentPageDao;
	
	
	public ContentPageDao getContentPageDao() {
		return contentPageDao;
	}

	public void setContentPageDao(ContentPageDao contentPageDao) {
		this.contentPageDao = contentPageDao;
	}

	public void saveModel(ContentPageModel model)
	{
		getContentPageDao().saveModel(model);
	}

	public ContentPageModel getModel(int id)
	{
		return (ContentPageModel) getContentPageDao().getModel(id);
	}

	public void deleteMOdel(ContentPageModel model)
	{
		getContentPageDao().deleteModel(model);
	}

	public void updateModel(ContentPageModel model)
	{
		getContentPageDao().updateModel(model);
	}

	public List<ContentPageModel> getModels()
	{
		return getContentPageDao().getModels();
	}

	public ContentPageModel getPageForCode(String code)
	{
		return null;
	}


	public ContentPageModel getDefaultPage(String pageCode)
	{
		return getContentPageDao().getDefaultPage(pageCode);
	}

}
