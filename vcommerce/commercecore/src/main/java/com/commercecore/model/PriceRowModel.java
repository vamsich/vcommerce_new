package com.commercecore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="priceRow")
public class PriceRowModel 
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private Double value;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="currencyId")
	private CurrencyModel currency;
	
}
