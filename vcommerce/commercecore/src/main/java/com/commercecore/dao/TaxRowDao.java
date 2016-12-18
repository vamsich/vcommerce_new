package com.commercecore.dao;

import java.util.List;

import com.commercecore.model.TaxRowModel;


public interface TaxRowDao
{
	Object getModel(int id);
	void saveModel(TaxRowModel model);
	void updateModel(TaxRowModel model);
	void deleteModel(TaxRowModel model);
	List<TaxRowModel> getModels();
}
