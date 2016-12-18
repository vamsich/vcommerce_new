package com.commercecore.service.impl;

import java.util.List;
import com.commercecore.dao.CartDao;
import com.commercecore.model.CartModel;
import com.commercecore.service.CartService;

public class DefaultCartService implements CartService
{
	private CartDao cartDao;
	
	
	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public void saveModel(CartModel model) 
	{
		getCartDao().saveModel(model);
	}

	public CartModel getModel(int id) 
	{
		return (CartModel) getCartDao().getModel(id);
	}

	public void deleteMOdel(CartModel model) 
	{
		getCartDao().deleteModel(model);
	}

	public void updateModel(CartModel model) 
	{
		getCartDao().updateModel(model);
	}

	public List<CartModel> getModels() 
	{
		return getCartDao().getModels();
	}
	
}
