package com.di.world.search;

import javax.xml.namespace.QName;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.DocumentManager;
import com.marklogic.client.io.SearchHandle;
import com.marklogic.client.io.StringHandle;
import com.marklogic.client.query.KeyValueQueryDefinition;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.StringQueryDefinition;
import com.di.world.search.Config;

public class MarkLogicSearch {
	private DatabaseClient client;
	private QueryManager queryMgr;
	private DocumentManager docManager;
	
	public MarkLogicSearch() {
		// create the client
		client = DatabaseClientFactory.newClient(Config.host, Config.port, Config.user, Config.password, Config.authType);
		// create a manager for searching
		queryMgr = client.newQueryManager();
		docManager = client.newXMLDocumentManager();
	}
	
	public String SearchString(String search) {
		
		// create a search definition
		StringQueryDefinition query = queryMgr.newStringDefinition();
		query.setCriteria(search);

		// create a handle for the search results
		StringHandle resultsHandle = new StringHandle();

		// run the search
		queryMgr.search(query, resultsHandle);

		// release the client
		client.release();
		
		return resultsHandle.toString();
	}
	
	public SearchHandle SearchStringHandler(String search) {
		
		// create a search definition
		StringQueryDefinition query = queryMgr.newStringDefinition();
		query.setCriteria(search);

		// create a handle for the search results
		SearchHandle resultsHandle = new SearchHandle();

		// run the search
		queryMgr.search(query, resultsHandle);

		// release the client
		client.release();
		
		return resultsHandle;
	}
	
	public SearchHandle searchElementValue(String element, String value) {
		// create a search definition
		KeyValueQueryDefinition query = queryMgr.newKeyValueDefinition();
		query.put(queryMgr.newElementLocator(new QName(element)),value);

		// create a handle for the search results
		SearchHandle resultsHandle = new SearchHandle();

		// run the search
		queryMgr.search(query, resultsHandle);

		// release the client
		client.release();
		
		return resultsHandle;
	}
	
	public String readDocument(String uri) {
		StringHandle content = new StringHandle();
		docManager.read(uri, content);
		return content.toString();
	}
	
	

}
