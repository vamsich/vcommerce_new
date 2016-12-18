package com.commercecontent.service;

import java.util.List;

import com.commercecontent.model.ContentPageModel;

public interface ContentPageService 
{
	void saveModel(ContentPageModel model);
	ContentPageModel getModel(int id);
	void deleteMOdel(ContentPageModel model);
	void updateModel(ContentPageModel model);
	List<ContentPageModel> getModels();
}
