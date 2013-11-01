package com.di.world.dao;

import com.di.world.entity.MarkLogic.MarkLogicDocumentSummary;

public interface MarkLogicSearchDAO {
	MarkLogicDocumentSummary[] getElementValue(String element, String value) throws Exception;
	MarkLogicDocumentSummary[] getValue(String value) throws Exception;
	String readDocument(String uri) throws Exception;

}
