package com.commercecore.dao;

import java.util.List;

import com.commercecore.model.CatalogModel;


public interface CatelogDao
{
	Object getModel(int id);
	void saveModel(CatalogModel model);
	void updateModel(CatalogModel model);
	void deleteModel(CatalogModel model);
	List<CatalogModel> getModels();
}
