package com.di.world.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Currencies")
public class CurrencyCountryListEntity {
	List<CurrencyInfoEntity> currency = new ArrayList<CurrencyInfoEntity>();

	@XmlElement(name = "Currency", type = CurrencyInfoEntity.class)
	public List<CurrencyInfoEntity> getCurrency() {
		Collections.sort(currency);
		return currency;
	}

	public void setCurrency(List<CurrencyInfoEntity> currency) {
		this.currency = currency;
	}

}
