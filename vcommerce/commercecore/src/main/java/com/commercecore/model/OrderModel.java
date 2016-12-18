package com.commercecore.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="order")
public class OrderModel 
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String code;
	
	/*@Column
	private Set<OrderEntryModel> orderEntries;*/
	
	@Column
	private Double subTotal;
	
	@Column
	private Double totalAmount;
	
	/*@Column
	private AddressModel deliveyAddress;
	
	@Column
	private AddressModel billingAddress;*/
	
	
}
