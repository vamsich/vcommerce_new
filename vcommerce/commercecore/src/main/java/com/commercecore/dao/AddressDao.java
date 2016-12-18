package com.commercecore.dao;

import java.util.List;

import com.commercecore.model.AddressModel;


public interface AddressDao
{
	Object getModel(int id);
	void saveModel(AddressModel model);
	void updateModel(AddressModel model);
	void deleteModel(AddressModel model);
	List<AddressModel> getModels();
}
