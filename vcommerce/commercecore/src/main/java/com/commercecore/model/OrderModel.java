package com.commercecore.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Arun1234
 *
 */
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	/*@Column
	private AddressModel deliveyAddress;
	
	@Column
	private AddressModel billingAddress;*/
	
}
