package com.commercecore.dao;

import java.util.List;

import com.commercecore.model.BaseStoreModel;

public interface BaseStoreDao
{
	Object getModel(int id);
	void saveModel(BaseStoreModel model);
	void updateModel(BaseStoreModel model);
	void deleteModel(BaseStoreModel model);
	List<BaseStoreModel> getModels();
}
