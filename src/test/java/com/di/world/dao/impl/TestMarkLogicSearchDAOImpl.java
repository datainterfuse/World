package com.di.world.dao.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.di.world.entity.MarkLogic.MarkLogicDocumentSummary;

public class TestMarkLogicSearchDAOImpl {
	MarkLogicSearchDAOImpl dao;

	@Before
	public void setUp() throws Exception {
		dao = new MarkLogicSearchDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testGetElementValue() {
		assertTrue(true);
	}

	@Test
	public void testGetValue() throws Exception {
		MarkLogicDocumentSummary[] docs = dao.getValue("Iran");
		assertNotNull(docs);
	}

}
