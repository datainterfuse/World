package com.di.world.entity;

import java.util.ArrayList;
import java.util.List;

public class LanguageInfoEntity implements Comparable<LanguageInfoEntity> {
	private LanguageEntity language;
	private List<CountryEntity> countries = new  ArrayList<CountryEntity>();
	
	public LanguageEntity getLanguage() {
		return language;
	}
	public void setLanguage(LanguageEntity language) {
		this.language = language;
	}
	public List<CountryEntity> getCountries() {
		return countries;
	}
	public void setCountries(List<CountryEntity> countries) {
		this.countries = countries;
	}

	public int compareTo(LanguageInfoEntity o) {
		return language.getName().compareTo(o.getLanguage().getName());
	}

}
