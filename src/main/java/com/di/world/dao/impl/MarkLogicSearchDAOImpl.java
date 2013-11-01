package com.di.world.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.di.world.dao.MarkLogicSearchDAO;
import com.di.world.entity.MarkLogic.MarkLogicDocumentSummary;
import com.di.world.search.MarkLogicSearch;
import com.di.world.utils.MarkLogicUtil;
import com.marklogic.client.document.DocumentManager;
import com.marklogic.client.io.SearchHandle;
import com.marklogic.client.query.MatchDocumentSummary;

@Repository
public class MarkLogicSearchDAOImpl implements MarkLogicSearchDAO {

	public MarkLogicDocumentSummary[] getElementValue(String element, String value) throws Exception {
		MarkLogicSearch mls = new MarkLogicSearch();
		SearchHandle search = mls.searchElementValue(element, value);
		List<MarkLogicDocumentSummary> list = new ArrayList<MarkLogicDocumentSummary>();
		for (MatchDocumentSummary doc : search.getMatchResults()) {
			list.add(MarkLogicUtil.convertDocument(doc));
		}
		return convertToArray(list);
	}

	public MarkLogicDocumentSummary[] getValue(String value) throws Exception {
		MarkLogicSearch mls = new MarkLogicSearch();
		SearchHandle search = mls.SearchStringHandler(value);
		List<MarkLogicDocumentSummary> list = new ArrayList<MarkLogicDocumentSummary>();
		for (MatchDocumentSummary doc : search.getMatchResults()) {
			list.add(MarkLogicUtil.convertDocument(doc));
		}
		return convertToArray(list);
	}
	
	private MarkLogicDocumentSummary[] convertToArray(List<MarkLogicDocumentSummary> list) {
		MarkLogicDocumentSummary[] docs = new MarkLogicDocumentSummary[list.size()];
		for (int i = 0; i < list.size(); i++) {
			docs[i] = list.get(i);
		}
		return docs;
	}

	public String readDocument(String uri) throws Exception {
		MarkLogicSearch mls = new MarkLogicSearch();
		return mls.readDocument(uri);
	}

}
