package com.di.world.dao.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.di.world.entity.LanguageCountryListEntity;

public class TestLanguageDAOImpl {
	private LanguageDAOImpl dao;

	@Before
	public void setUp() throws Exception {
		dao = new LanguageDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testGetLanguages() throws Exception {
		LanguageCountryListEntity list = dao.getLanguages();
		assertNotNull(list);
	}

}
