package com.di.world.utils;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestRestServices {
	RestServices rs;
	
	@Before
	public void setUp() {
		rs = new RestServices();
	}

	@After
	public void tearDown() throws Exception {
		rs = null;
	}

	@Test
	public void testGet() throws Exception{
		String response = rs.get("http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/ListOfCountryNamesByCode/JSON");
		System.out.println(response);
		assertNotNull(response);
	}
	
	@Test
	public void TestMarkLogicDocumentSummary() {
		
	}

}
