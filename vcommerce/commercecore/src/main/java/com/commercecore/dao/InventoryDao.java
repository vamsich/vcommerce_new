package com.commercecore.dao;

import java.util.List;

import com.commercecore.model.InventoryModel;


public interface InventoryDao
{
	Object getModel(int id);
	void saveModel(InventoryModel model);
	void updateModel(InventoryModel model);
	void deleteModel(InventoryModel model);
	List<InventoryModel> getModels();
}
