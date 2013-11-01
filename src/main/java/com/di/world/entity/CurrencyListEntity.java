package com.di.world.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ArrayOftCurrency")
public class CurrencyListEntity {
	private List<CurrencyEntity> currencies = new ArrayList<CurrencyEntity>();

	@XmlElement(name="tCurrency", type = CurrencyEntity.class)
	public List<CurrencyEntity> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<CurrencyEntity> currencies) {
		this.currencies = currencies;
	}
	
	

}
