package com.di.world.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.world.dao.CountryDAO;
import com.di.world.entity.CountryInfoEntity;
import com.di.world.service.CountryManager;

@Service
public class CountryManagerImpl implements CountryManager {
	@Autowired
	CountryDAO dao;

	public CountryInfoEntity getInfo(String code) {
		try {
			return dao.getInfo(code);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
