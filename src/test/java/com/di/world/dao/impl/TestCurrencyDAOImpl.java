package com.di.world.dao.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.di.world.entity.CountryListEntity;
import com.di.world.entity.CurrencyCountryListEntity;
import com.di.world.entity.CurrencyListEntity;

public class TestCurrencyDAOImpl {
	private CurrencyDAOImpl cdi;

	@Before
	public void setUp() throws Exception {
		cdi = new CurrencyDAOImpl();
	}
	
	@After
	public void tearDown() throws Exception {
		cdi = null;
	}

	@Test
	public void testGetCurrencyNames() throws Exception {
		CurrencyListEntity list = cdi.getCurrencyNames();
		assertNotNull(list);
	}

	@Test
	public void testGetCountries() throws Exception {
		CountryListEntity list = cdi.getCountries("AFA");
		assertNotNull(list);
	}

	@Test
	public void testGetCurrency() throws Exception {
		CurrencyCountryListEntity list = cdi.getCurrency();
		assertNotNull(list);
		//assertTrue(true);
	}

}
