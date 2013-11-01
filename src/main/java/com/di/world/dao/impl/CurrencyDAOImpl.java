package com.di.world.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.di.world.dao.CurrencyDAO;
import com.di.world.entity.ContinentListEntity;
import com.di.world.entity.CountryArrayEntity;
import com.di.world.entity.CountryEntity;
import com.di.world.entity.CountryInfoEntity;
import com.di.world.entity.CountryListEntity;
import com.di.world.entity.CurrencyCountryListEntity;
import com.di.world.entity.CurrencyEntity;
import com.di.world.entity.CurrencyInfoEntity;
import com.di.world.entity.CurrencyListEntity;
import com.di.world.utils.RestServices;
import com.di.world.utils.XmlUtilities;

@Repository
public class CurrencyDAOImpl implements CurrencyDAO {
	private RestServices rest;
	private String url = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/";
	
	public CurrencyDAOImpl() {
		rest = new RestServices();
	}
	
	public CurrencyListEntity getCurrencyNames() throws Exception {
		String result = rest.get(url + "ListOfCurrenciesByName/");
		return new XmlUtilities().unMarshal(result, CurrencyListEntity.class);
	}

	public CountryListEntity getCountries(String code) throws Exception {
		String result = rest.get(url + "CountriesUsingCurrency?sISOCurrencyCode=" + code);
		return new XmlUtilities().unMarshal(result, CountryListEntity.class);
	}

	public CurrencyCountryListEntity getCurrency() throws Exception {
		CurrencyCountryListEntity entity = new CurrencyCountryListEntity();
		/*CurrencyListEntity currency = getCurrencyNames();
		for (CurrencyEntity ce : currency.getCurrencies()) {
			CurrencyInfoEntity cie = new CurrencyInfoEntity();
			cie.setCurrency(ce);
			CountryListEntity cle = getCountries(ce.getCode());
			cie.setCountries(cle.getCountries());
			entity.getCurrency().add(cie);
		}*/
		Map<String, List<CountryEntity>> values = new HashMap<String, List<CountryEntity>>();
		CurrencyListEntity currency = getCurrencyNames();
		Map<String, String> cList = new HashMap<String, String>();
		for (CurrencyEntity ce : currency.getCurrencies()) {
			cList.put(ce.getCode(), ce.getName());
		}
		String result = rest.get(url + "FullCountryInfoAllCountries");
		CountryArrayEntity country =  new XmlUtilities().unMarshal(result, CountryArrayEntity.class);
		for (CountryInfoEntity cie : country.getCountries()) {
			String code = cie.getCurrencyCode();
			String nm = cList.get(code);
			if (values.containsKey(code)) {
				List<CountryEntity> list = values.get(code);
				CountryEntity ce = new CountryEntity();
				ce.setCode(cie.getName());
				ce.setName(cie.getName());
				list.add(ce);
			} else {
				List<CountryEntity> first = new ArrayList<CountryEntity>();
				CountryEntity ce = new CountryEntity();
				ce.setCode(cie.getName());
				ce.setName(cie.getName());
				first.add(ce);
				values.put(code, first);
			}
		}
		for (String c : values.keySet()) {
			List<CountryEntity> countries = values.get(c);
			CurrencyEntity cEnt = new CurrencyEntity();
			cEnt.setCode(c);
			cEnt.setName(cList.get(c));
			CurrencyInfoEntity info = new CurrencyInfoEntity();
			info.setCurrency(cEnt);
			info.setCountries(countries);
			entity.getCurrency().add(info);
		}
		
		return entity;
	}
	

}
