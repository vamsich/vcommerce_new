package com.commercecore.dao;

import java.util.List;

import com.commercecore.model.CurrencyModel;


public interface CurrencyDao
{
	Object getModel(int id);
	void saveModel(CurrencyModel model);
	void updateModel(CurrencyModel model);
	void deleteModel(CurrencyModel model);
	List<CurrencyModel> getModels();
}
