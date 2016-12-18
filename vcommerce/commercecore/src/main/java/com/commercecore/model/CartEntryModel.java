package com.commercecore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cartEntry")
public class CartEntryModel 
{
	@Id
	@GeneratedValue
	private int id;
}
