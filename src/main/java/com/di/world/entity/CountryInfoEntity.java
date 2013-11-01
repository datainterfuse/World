package com.di.world.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tCountryInfo")
public class CountryInfoEntity {
	private String code;
	private String name;
	private String capital;
	private String phoneCode;
	private String continentCode;
	private String currencyCode;
	private String currencyName;
	private String flagLink;
	private LanguageListEntity languages;
	
	@XmlElement(name = "sISOCode")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@XmlElement(name = "sName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name = "sCapitalCity")
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	@XmlElement(name = "sPhoneCode")
	public String getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}
	@XmlElement(name = "sContinentCode")
	public String getContinentCode() {
		return continentCode;
	}
	public void setContinentCode(String continentCode) {
		this.continentCode = continentCode;
	}
	@XmlElement(name = "sCurrencyISOCode")
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	@XmlElement(name = "sCurrencyCode")
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	@XmlElement(name = "sCountryFlag")
	public String getFlagLink() {
		return flagLink;
	}
	public void setFlagLink(String flagLink) {
		this.flagLink = flagLink;
	}
	@XmlElement(name = "Languages")
	public LanguageListEntity getLanguages() {
		return languages;
	}
	public void setLanguages(LanguageListEntity languages) {
		this.languages = languages;
	}
	
	

}
