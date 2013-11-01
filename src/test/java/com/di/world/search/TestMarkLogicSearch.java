package com.di.world.search;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.di.world.utils.MarkLogicUtil;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.io.SearchHandle;
import com.marklogic.client.io.StringHandle;
import com.marklogic.client.query.MatchDocumentSummary;
import com.marklogic.client.query.MatchLocation;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.StringQueryDefinition;

public class TestMarkLogicSearch {
	private MarkLogicSearch mls;

	@Before
	public void setUp() throws Exception {
		mls = new MarkLogicSearch();
	}

	@After
	public void tearDown() throws Exception {
		mls = null;
	}

	@Test
	public void testSearchString() {
		String result = mls.SearchString("Iran");
		assertNotNull(result);
	}
	
	@Test
	public void teestResults() {
		// create the client
		DatabaseClient client = DatabaseClientFactory.newClient(Config.host, Config.port, Config.user, Config.password, Config.authType);

		// create a manager for searching
		QueryManager queryMgr = client.newQueryManager();

		// create a search definition
		StringQueryDefinition query = queryMgr.newStringDefinition();
		query.setCriteria("Iran");

		// create a handle for the search results
		SearchHandle resultsHandle = new SearchHandle();

		// run the search
		queryMgr.search(query, resultsHandle);
		
		MarkLogicUtil.displayResults(resultsHandle);

		// release the client
		client.release();
	}
	
	@Test
	public void testReadDocument() {
		// create the client
		DatabaseClient client = DatabaseClientFactory.newClient(Config.host, Config.port, Config.user, Config.password, Config.authType);

		// create a manager for searching
		QueryManager queryMgr = client.newQueryManager();

		// create a search definition
		StringQueryDefinition query = queryMgr.newStringDefinition();
		query.setCriteria("Iran");

		// create a handle for the search results
		SearchHandle resultsHandle = new SearchHandle();

		// run the search
		queryMgr.search(query, resultsHandle);
		
		for (MatchDocumentSummary mds : resultsHandle.getMatchResults()) {
			String data = mls.readDocument(mds.getUri());
			assertNotNull(data);
		}
		
	}
}
