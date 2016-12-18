package com.commercecore.service;

import java.util.List;

import com.commercecore.model.CartModel;

public interface CartService
{
	void saveModel(CartModel model);
	CartModel getModel(int id);
	void deleteMOdel(CartModel model);
	void updateModel(CartModel model);
	List<CartModel> getModels();
}
