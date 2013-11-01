package com.di.world.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.world.dao.CurrencyDAO;
import com.di.world.entity.CountryListEntity;
import com.di.world.entity.CurrencyCountryListEntity;
import com.di.world.entity.CurrencyListEntity;
import com.di.world.service.CurrencyManager;

@Service
public class CurrencyManagerImpl implements CurrencyManager {
	@Autowired
	private CurrencyDAO dao;

	public CurrencyListEntity getCurrencyNames() {
		try {
			return dao.getCurrencyNames();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public CountryListEntity getCountries(String code) {
		try {
			return dao.getCountries(code);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public CurrencyCountryListEntity getCurrency() {
		try {
			return dao.getCurrency();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
