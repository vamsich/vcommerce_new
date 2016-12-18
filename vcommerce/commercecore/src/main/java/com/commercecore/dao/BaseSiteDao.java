package com.commercecore.dao;

import java.util.List;

import com.commercecore.model.BaseSiteModel;

public interface BaseSiteDao
{
	Object getModel(int id);
	void saveModel(BaseSiteModel model);
	void updateModel(BaseSiteModel model);
	void deleteModel(BaseSiteModel model);
	List<BaseSiteModel> getModels();
}
