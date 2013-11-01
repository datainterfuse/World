package com.di.world.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.di.world.entity.FlagInfoEntity;

public class TestFlagDAOImpl {
	private FlagDAOImpl dao;

	@Before
	public void setUp() throws Exception {
		dao = new FlagDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testGetFlags() throws Exception {
		List<FlagInfoEntity> list = dao.getFlags();
		assertNotNull(list);
	}

}
