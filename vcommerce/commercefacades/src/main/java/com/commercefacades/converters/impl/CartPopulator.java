package com.commercefacades.converters.impl;

import com.commercecore.model.CartModel;
import com.commercefacades.converters.Populator;
import com.commercefacades.data.CartData;

public class CartPopulator implements Populator<CartModel, CartData> 
{
	public CartData populate(CartModel source, CartData target) 
	{
		return new CartData();
	}
}
