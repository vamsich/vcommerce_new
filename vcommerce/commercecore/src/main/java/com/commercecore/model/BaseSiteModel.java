package com.commercecore.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="basesite")
public class BaseSiteModel 
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String siteId;
	
	@Column
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "storeID")
	private BaseStoreModel baseStore;
	
	@Column
	private String version;	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="langId")
	private LanguageModel defaultLanguage;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="currencyId")
	private CurrencyModel defaultCurency;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	
	public BaseStoreModel getBaseStore() {
		return baseStore;
	}

	public void setBaseStore(BaseStoreModel baseStore) {
		this.baseStore = baseStore;
	}

	public LanguageModel getDefaultLanguage() {
		return defaultLanguage;
	}

	public void setDefaultLanguage(LanguageModel defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}

	public CurrencyModel getDefaultCurency() {
		return defaultCurency;
	}

	public void setDefaultCurency(CurrencyModel defaultCurency) {
		this.defaultCurency = defaultCurency;
	}
	
}
