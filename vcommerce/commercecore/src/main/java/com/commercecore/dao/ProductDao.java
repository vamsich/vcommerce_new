package com.commercecore.dao;


import java.util.List;

import com.commercecore.model.ProductModel;


public interface ProductDao
{
	Object getModel(int id);
	void saveModel(ProductModel model);
	void updateModel(ProductModel model);
	void deleteModel(ProductModel model);
	List<ProductModel> getModels();
}
