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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contentpage")
public class ContentPageModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="page_id")
	private int id;
	
	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column
	private String pageName;
	
	@Column
	private String pageCode;
	
	@Column
	private boolean isDefault;
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity= SlotModel.class,cascade= CascadeType.ALL)
	@JoinTable(name="page_slots", joinColumns={@JoinColumn(name = "page_id")}, inverseJoinColumns = {
	        @JoinColumn(name = "slotid")})
	private Set<SlotModel> slots;
	
	@OneToOne
	@JoinColumn(name="pageTemplate")
	private PageTemplateModel pageTemplate;
	
	public Set<SlotModel> getSlots() {
		return slots;
	}
	public void setSlots(Set<SlotModel> slots) {
		this.slots = slots;
	}
	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	
	public String getPageCode()
	{
		return pageCode;
	}
	public void setPageCode(String pageCode)
	{
		this.pageCode = pageCode;
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
	public String getPageName() {
		
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public PageTemplateModel getPageTemplate() {
		return pageTemplate;
	}
	public void setPageTemplate(PageTemplateModel pageTemplate) {
		this.pageTemplate = pageTemplate;
	}
	
}
