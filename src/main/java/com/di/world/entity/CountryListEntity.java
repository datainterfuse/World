package com.di.world.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ArrayOftCountryCodeAndName")
public class CountryListEntity {
	private List<CountryEntity> countries;

	@XmlElement(name = "tCountryCodeAndName", type = CountryEntity.class)
	public List<CountryEntity> getCountries() {
		return countries;
	}

	public void setCountries(List<CountryEntity> countries) {
		this.countries = countries;
	}
	
	

}
