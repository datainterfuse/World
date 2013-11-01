package com.di.world.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ArrayOftCountryCodeAndNameGroupedByContinent")
public class ContinentListEntity {
	private List<ContinentInfoEntity> continents = new ArrayList<ContinentInfoEntity>();

	@XmlElement(name = "tCountryCodeAndNameGroupedByContinent", type = ContinentInfoEntity.class)
	public List<ContinentInfoEntity> getContinents() {
		return continents;
	}

	public void setContinents(List<ContinentInfoEntity> continents) {
		this.continents = continents;
	}
	
	

}
