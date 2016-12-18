package com.commercecore.model;

import java.io.Serializable;


public class JaloSession implements Serializable
{
	private static final long serialVersionUID = 1L;
	private UserModel user;
	private CartModel cart;
	private CurrencyModel currency;
	private LanguageModel languageModel;
	public UserModel getUser()
	{
		return user;
	}
	public void setUser(UserModel user)
	{
		this.user = user;
	}
	public CartModel getCart()
	{
		return cart;
	}
	public void setCart(CartModel cart)
	{
		this.cart = cart;
	}
	public CurrencyModel getCurrency()
	{
		return currency;
	}
	public void setCurrency(CurrencyModel currency)
	{
		this.currency = currency;
	}
	public LanguageModel getLanguageModel()
	{
		return languageModel;
	}
	public void setLanguageModel(LanguageModel languageModel)
	{
		this.languageModel = languageModel;
	}
}
