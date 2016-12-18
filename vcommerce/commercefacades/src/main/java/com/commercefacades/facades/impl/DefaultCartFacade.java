package com.commercefacades.facades.impl;

import com.commercecore.model.CartModel;
import com.commercecore.service.CartService;
import com.commercefacades.data.CartData;
import com.commercefacades.facades.CartFacade;

public class DefaultCartFacade implements CartFacade
{
	
	private CartService cartService;
	
	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public boolean checkCart() 
	{
		return false;
	}

	public void saveCart(CartData cartData) 
	{
		cartService.saveModel(new CartModel());
	}

	public void updateCart(CartData cartData) 
	{
		
	}

	public CartData getSessionCart() 
	{
		return null;
	}

}
