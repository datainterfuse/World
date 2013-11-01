package com.di.world.dao.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.di.world.entity.ContinentListEntity;
import com.di.world.entity.CountryListEntity;

public class TestContinentDAOImpl {
	private ContinentDAOImpl cdi;

	@Before
	public void setUp() throws Exception {
		cdi = new ContinentDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		cdi = null;
	}

	@Test
	public void testGetContinents() throws Exception {
		ContinentListEntity cle = cdi.getContinents();
		assertNotNull(cle);
	}
	
	@Test
	public void testGetCountriesFromContinent() throws Exception {
		CountryListEntity cle = cdi.getCountriesFromContinent("AM");
		assertNotNull(cle);
	}
	

}
