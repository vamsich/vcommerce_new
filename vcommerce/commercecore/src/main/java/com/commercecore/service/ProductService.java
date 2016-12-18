package com.commercecore.service;

import java.util.List;

import com.commercecore.model.ProductModel;

public interface ProductService 
{
	void saveModel(ProductModel model);
	ProductModel getModel(int id);
	void deleteMOdel(ProductModel model);
	void updateModel(ProductModel model);
	List<ProductModel> getModels();
}
