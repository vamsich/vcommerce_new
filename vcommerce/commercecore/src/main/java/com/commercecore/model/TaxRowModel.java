package com.commercecore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taxrow")
public class TaxRowModel 
{
	@Id
	private int id;
	
	@Column
	private Double value;
	
	@Column
	private String name;
}
