package com.di.world.dao.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.di.world.entity.CountryEntity;
import com.di.world.entity.CountryInfoEntity;
import com.di.world.entity.CountryListEntity;

public class TestCountryDAOImpl {
	CountryDAOImpl country;

	@Before
	public void setUp() throws Exception {
		country = new CountryDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		country = null;
	}

	@Test
	public void testGetCountries() throws Exception {
		CountryListEntity result = country.getCountries();
		assertNotNull(result);
	}
	
	@Test
	public void testGetInfo() throws Exception {
		CountryInfoEntity cie = country.getInfo("AF");
		assertNotNull(cie);
	}

}
