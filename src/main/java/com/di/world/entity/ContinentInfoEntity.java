package com.di.world.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tCountryCodeAndNameGroupedByContinent")
public class ContinentInfoEntity {
	private ContinentEntity continent;
	private List<CountryListEntity> countries = new ArrayList<CountryListEntity>();
	
	@XmlElement(name = "Continent")
	public ContinentEntity getContinent() {
		return continent;
	}
	public void setContinent(ContinentEntity continent) {
		this.continent = continent;
	}
	@XmlElement(name = "CountryCodeAndNames", type = CountryListEntity.class)
	public List<CountryListEntity> getCountries() {
		return countries;
	}
	public void setCountries(List<CountryListEntity> countries) {
		this.countries = countries;
	}
	
	
}
