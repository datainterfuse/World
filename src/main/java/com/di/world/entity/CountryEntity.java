package com.di.world.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tCountryCodeAndName")
public class CountryEntity {
	private String code;
	private String name;
	
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

}
