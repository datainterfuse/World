package com.di.world.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.world.dao.LanguageDAO;
import com.di.world.entity.LanguageCountryListEntity;
import com.di.world.service.LanguageManager;

@Service
public class LanguageManagerImpl implements LanguageManager {
	@Autowired
	LanguageDAO dao;
	
	public LanguageCountryListEntity getLanguages() {
		try {
			return dao.getLanguages();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
