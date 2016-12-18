package com.commercecore.service;

import java.util.List;

import com.commercecore.model.BaseStoreModel;

public interface BaseStoreService 
{
	void saveModel(BaseStoreModel model);
	BaseStoreModel getModel(int id);
	void deleteMOdel(BaseStoreModel model);
	void updateModel(BaseStoreModel model);
	List<BaseStoreModel> getModels();
}
