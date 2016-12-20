package com.commercecontent.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="pageTemplate")
public class PageTemplateModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="template_id")
	private int id;
	
	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column
	private String frontPageName;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL,targetEntity = SlotModel.class)
	@JoinTable(name="template_slots", joinColumns={@JoinColumn(name = "template_id")}, inverseJoinColumns = {
	        @JoinColumn(name = "slotid")})
	private Set<SlotModel> availableSlots;
	
	public Set<SlotModel> getAvailableSlots() {
		return availableSlots;
	}
	public void setAvailableSlots(Set<SlotModel> availableSlots) {
		this.availableSlots = availableSlots;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrontPageName() {
		return frontPageName;
	}
	public void setFrontPageName(String frontPageName) {
		this.frontPageName = frontPageName;
	}
	
}
