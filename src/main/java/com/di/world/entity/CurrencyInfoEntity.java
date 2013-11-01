package com.di.world.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Currency")
public class CurrencyInfoEntity extends CurrencyEntity implements Comparable<CurrencyInfoEntity> {
	private CurrencyEntity currency;
	private List<CountryEntity> countries = new  ArrayList<CountryEntity>();

	@XmlElement(name = "Currency")
	public CurrencyEntity getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyEntity currency) {
		this.currency = currency;
	}

	@XmlElement(name = "Countries", type = CountryEntity.class)
	public List<CountryEntity> getCountries() {
		return countries;
	}

	public void setCountries(List<CountryEntity> countries) {
		this.countries = countries;
	}

	public int compareTo(CurrencyInfoEntity o) {
		return currency.getName().compareTo(o.getCurrency().getName());
	}
	
}
