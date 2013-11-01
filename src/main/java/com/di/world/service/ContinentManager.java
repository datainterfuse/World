package com.di.world.service;

import com.di.world.entity.ContinentEntity;
import com.di.world.entity.ContinentListEntity;
import com.di.world.entity.CountryListEntity;

public interface ContinentManager {
	public ContinentListEntity getContinents();
	public CountryListEntity getCountriesFromContinent(String code);
	public ContinentEntity getContinent(String code);

}
