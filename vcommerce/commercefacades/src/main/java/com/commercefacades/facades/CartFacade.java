package com.commercefacades.facades;

import com.commercefacades.data.CartData;

public interface CartFacade 
{
	boolean checkCart();
	void saveCart(CartData cartData);
	void updateCart(CartData cartData);
	CartData getSessionCart();
}
