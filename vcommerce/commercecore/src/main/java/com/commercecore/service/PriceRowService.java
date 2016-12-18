package com.commercecore.service;

import java.util.List;

import com.commercecore.model.PriceRowModel;

public interface PriceRowService 
{
	void saveModel(PriceRowModel model);
	PriceRowModel getModel(int id);
	void deleteMOdel(PriceRowModel model);
	void updateModel(PriceRowModel model);
	List<PriceRowModel> getModels();
}
