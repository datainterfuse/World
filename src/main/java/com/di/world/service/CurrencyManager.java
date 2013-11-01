package com.di.world.service;

import com.di.world.entity.CountryListEntity;
import com.di.world.entity.CurrencyCountryListEntity;
import com.di.world.entity.CurrencyListEntity;

public interface CurrencyManager {
	CurrencyListEntity getCurrencyNames();
	CountryListEntity getCountries(String code);
	CurrencyCountryListEntity getCurrency();

}
