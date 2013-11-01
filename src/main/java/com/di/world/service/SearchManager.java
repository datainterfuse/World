package com.di.world.service;

import com.di.world.entity.MarkLogic.MarkLogicDocumentSummary;

public interface SearchManager {
	
	MarkLogicDocumentSummary[] searchMarkLogicElementValue(String element, String value);
	MarkLogicDocumentSummary[] SearchStringHandler(String value);

}
