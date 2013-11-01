package com.di.world.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.world.dao.MarkLogicSearchDAO;
import com.di.world.entity.MarkLogic.MarkLogicDocumentSummary;
import com.di.world.service.SearchManager;
import com.marklogic.client.io.SearchHandle;

@Service
public class SearchManagerImpl implements SearchManager {
	@Autowired
	MarkLogicSearchDAO mls;

	public MarkLogicDocumentSummary[] searchMarkLogicElementValue(String element, String value) {
		try {
			return mls.getElementValue(element, value);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public MarkLogicDocumentSummary[] SearchStringHandler(String value) {
		try {
			return mls.getValue(value);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
