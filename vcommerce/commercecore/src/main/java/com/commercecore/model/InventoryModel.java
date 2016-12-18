package com.commercecore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class InventoryModel 
{
	@Id
	@GeneratedValue
	private int id;
	
}
