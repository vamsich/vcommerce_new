package com.commercecore.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="orderEntity")
public class OrderEntryModel 
{
	@Id
	@GeneratedValue
	private int id;
	
	/*private ProductModel product;*/
	
	@Column
	private Double totalPrice;
	
	@Column
	private int quantity;
	
	@Column
	private Double basePrice;
	
}
