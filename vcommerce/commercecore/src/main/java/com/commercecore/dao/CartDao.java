package com.commercecore.dao;

import java.util.List;

import com.commercecore.model.CartModel;


public interface CartDao
{
	Object getModel(int id);
	void saveModel(CartModel model);
	void updateModel(CartModel model);
	void deleteModel(CartModel model);
	List<CartModel> getModels();
}
