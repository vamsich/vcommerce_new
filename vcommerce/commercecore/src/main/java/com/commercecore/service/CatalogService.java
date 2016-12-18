package com.commercecore.service;

import java.util.List;

import com.commercecore.model.CatalogModel;

public interface CatalogService 
{
	void saveModel(CatalogModel model);
	CatalogModel getModel(int id);
	void deleteMOdel(CatalogModel model);
	void updateModel(CatalogModel model);
	List<CatalogModel> getModels();
}
