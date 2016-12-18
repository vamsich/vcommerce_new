package com.commercecore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="catalog")
public class CatalogModel 
{
	@Id
	@GeneratedValue
	private String id;
	
	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column
	private String version;
}
