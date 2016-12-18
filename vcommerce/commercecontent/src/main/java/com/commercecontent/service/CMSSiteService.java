package com.commercecontent.service;

import java.util.List;

import com.commercecontent.model.ContentPageModel;

public interface CMSSiteService
{
	void updateModel(ContentPageModel model);
	void deleteMOdel(ContentPageModel model);
	ContentPageModel getModel(int id);
	void saveModel(ContentPageModel model);
	ContentPageModel getPageForCode(String code);
	ContentPageModel getDefaultPage(String pageCode);
	List<ContentPageModel> getModels();
}
