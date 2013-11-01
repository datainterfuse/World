package com.di.world.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.world.dao.ContinentDAO;
import com.di.world.entity.ContinentEntity;
import com.di.world.entity.ContinentListEntity;
import com.di.world.entity.CountryEntity;
import com.di.world.entity.CountryListEntity;
import com.di.world.service.ContinentManager;

@Service
public class ContinentManagerImpl implements ContinentManager {
	@Autowired
	ContinentDAO dao;

	public ContinentListEntity getContinents() {
		try {
			return dao.getContinents();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public CountryListEntity getCountriesFromContinent(String code) {
		try {
			return dao.getCountriesFromContinent(code);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ContinentEntity getContinent(String code) {
		try {
			return dao.getContinent(code);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
