package com.di.world.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ArrayOftCountryInfo")
public class CountryArrayEntity {
	private List<CountryInfoEntity> countries = new ArrayList<CountryInfoEntity>();

	@XmlElement(name = "tCountryInfo", type = CountryInfoEntity.class)
	public List<CountryInfoEntity> getCountries() {
		return countries;
	}

	public void setCountries(List<CountryInfoEntity> countries) {
		this.countries = countries;
	}
	
	

}
