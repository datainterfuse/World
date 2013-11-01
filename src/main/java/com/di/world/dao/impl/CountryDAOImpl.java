package com.di.world.dao.impl;

import org.springframework.stereotype.Repository;

import com.di.world.dao.CountryDAO;
import com.di.world.entity.CountryInfoEntity;
import com.di.world.entity.CountryListEntity;
import com.di.world.entity.CurrencyEntity;
import com.di.world.utils.RestServices;
import com.di.world.utils.XmlUtilities;

@Repository
public class CountryDAOImpl implements CountryDAO {
	private RestServices rest;
	private String url = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/";
	
	public CountryDAOImpl() {
		rest = new RestServices();
	}

	public CountryListEntity getCountries() throws Exception {
		String result = rest.get(url + "ListOfCountryNamesByName");
		return new XmlUtilities().unMarshal(result, CountryListEntity.class);
		
	}

	public CountryInfoEntity getInfo(String code) throws Exception {
		String result = rest.get(url + "FullCountryInfo?sCountryISOCode=" + code);
		CountryInfoEntity entity = new XmlUtilities().unMarshal(result, CountryInfoEntity.class);
		CurrencyEntity currency = this.getCurrency(code);
		entity.setCurrencyName(currency.getName());
		return entity;
	}

	public CurrencyEntity getCurrency(String code) throws Exception {
		String result = rest.get(url + "CountryCurrency?sCountryISOCode=" + code);
		return new XmlUtilities().unMarshal(result, CurrencyEntity.class);
	}

}
