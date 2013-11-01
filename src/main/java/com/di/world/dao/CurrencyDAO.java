package com.di.world.dao;

import org.springframework.stereotype.Repository;

import com.di.world.entity.CountryListEntity;
import com.di.world.entity.CurrencyCountryListEntity;
import com.di.world.entity.CurrencyListEntity;

@Repository
public interface CurrencyDAO {
	CurrencyListEntity getCurrencyNames() throws Exception;
	CountryListEntity getCountries(String code) throws Exception;
	CurrencyCountryListEntity getCurrency() throws Exception;
}
