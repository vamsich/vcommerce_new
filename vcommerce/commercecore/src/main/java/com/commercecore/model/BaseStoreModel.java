package com.commercecore.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="baseStore")
public class BaseStoreModel 
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String storeId;
	
	@Column
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="languageId")
	private Set<LanguageModel> supportedLanguages;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="currencyId")
	private Set<CurrencyModel> supportedCurrencies;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="defaultCurrency")
	private CurrencyModel defaultCurency;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="defaultLanguage")
	private LanguageModel defaultLanguage;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="baseSiteId")
	private Set<BaseSiteModel> baseSite;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<LanguageModel> getSupportedLanguages() {
		return supportedLanguages;
	}

	public void setSupportedLanguages(Set<LanguageModel> supportedLanguages) {
		this.supportedLanguages = supportedLanguages;
	}

	public Set<CurrencyModel> getSupportedCurrencies() {
		return supportedCurrencies;
	}

	public void setSupportedCurrencies(Set<CurrencyModel> supportedCurrencies) {
		this.supportedCurrencies = supportedCurrencies;
	}

	public CurrencyModel getDefaultCurency() {
		return defaultCurency;
	}

	public void setDefaultCurency(CurrencyModel defaultCurency) {
		this.defaultCurency = defaultCurency;
	}

	public LanguageModel getDefaultLanguage() {
		return defaultLanguage;
	}

	public void setDefaultLanguage(LanguageModel defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}

	public Set<BaseSiteModel> getBaseSite() {
		return baseSite;
	}

	public void setBaseSite(Set<BaseSiteModel> baseSite) {
		this.baseSite = baseSite;
	}
	
}
