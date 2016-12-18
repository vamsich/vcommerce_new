package com.commercecore.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CartModel 
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private Double cartTotal;
	
}
