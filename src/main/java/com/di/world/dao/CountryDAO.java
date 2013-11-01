package com.di.world.dao;

import com.di.world.entity.CountryInfoEntity;
import com.di.world.entity.CountryListEntity;
import com.di.world.entity.CurrencyEntity;

public interface CountryDAO {
	
	CountryListEntity getCountries() throws Exception;
	CountryInfoEntity getInfo(String code) throws Exception;
	CurrencyEntity getCurrency(String code) throws Exception;

}
