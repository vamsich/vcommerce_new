package com.commercecore.dao;


import java.util.List;

import com.commercecore.model.PriceRowModel;


public interface PriceRowDao extends GenericDao<PriceRowModel>
{
	Object getModel(int id);
	void saveModel(PriceRowModel model);
	void updateModel(PriceRowModel model);
	void deleteModel(PriceRowModel model);
	List<PriceRowModel> getModels();
}
