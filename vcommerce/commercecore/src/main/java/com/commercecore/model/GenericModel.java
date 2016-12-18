package com.commercecore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name="generic")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class GenericModel 
{
	@Id
	@GeneratedValue
	private String id;
	
	@Column
	private Date createdTime;
	
	@Column
	private Date modifiedTime;
	
	
}
