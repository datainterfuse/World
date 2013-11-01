package com.di.world.dao;

import java.util.List;

import com.di.world.entity.ContinentEntity;
import com.di.world.entity.ContinentInfoEntity;
import com.di.world.entity.ContinentListEntity;
import com.di.world.entity.CountryEntity;
import com.di.world.entity.CountryListEntity;

public interface ContinentDAO {
	
	ContinentListEntity getContinents() throws Exception;
	CountryListEntity getCountriesFromContinent(String code) throws Exception;
	ContinentEntity getContinent(String code) throws Exception;

}
