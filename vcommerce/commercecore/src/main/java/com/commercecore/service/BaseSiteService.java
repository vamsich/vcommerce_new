package com.commercecore.service;

import java.util.List;

import com.commercecore.model.BaseSiteModel;

public interface BaseSiteService 
{
	void saveModel(BaseSiteModel model);
	BaseSiteModel getModel(int id);
	void deleteMOdel(BaseSiteModel model);
	void updateModel(BaseSiteModel model);
	List<BaseSiteModel> getModels();
}
