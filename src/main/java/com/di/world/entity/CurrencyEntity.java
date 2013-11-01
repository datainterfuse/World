package com.di.world.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tCurrency")
public class CurrencyEntity {
	String code;
	String name;
	
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
