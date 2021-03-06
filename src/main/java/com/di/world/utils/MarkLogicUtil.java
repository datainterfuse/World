package com.di.world.utils;

import java.util.ArrayList;
import java.util.List;

import com.di.world.entity.MarkLogic.MarkLogicDocumentSummary;
import com.di.world.entity.MarkLogic.MarkLogicLocation;
import com.di.world.entity.MarkLogic.MarkLogicSnippet;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.SearchHandle;
import com.marklogic.client.io.StringHandle;
import com.marklogic.client.query.MatchDocumentSummary;
import com.marklogic.client.query.MatchLocation;
import com.marklogic.client.query.MatchSnippet;

public class MarkLogicUtil {
	public static void displayResultURIs(SearchHandle resultsHandle) {
		// Get the list of matching documents in this page of results
		MatchDocumentSummary[] results = resultsHandle.getMatchResults();
		
		System.out.println("Listing " + results.length + " documents:");
		
		// List the URI of each matching document
		for (MatchDocumentSummary result : results) {
			System.out.println(result.getUri());
		}
	}
	
	public static void displayJSONResultDocs(SearchHandle resultsHandle, DatabaseClient client) {
		JSONDocumentManager mgr = client.newJSONDocumentManager();
		
		// iterate over the result documents
		MatchDocumentSummary[] results = resultsHandle.getMatchResults();
		System.out.println("Listing "+results.length+" documents:\n");
		for (MatchDocumentSummary result: results) {
			StringHandle content = new StringHandle();
			mgr.read(result.getUri(), content);
			System.out.println(content.get());
		}
	}
	
	public static void displayResults(SearchHandle resultsHandle) {
		System.out.println("Matched "+resultsHandle.getTotalResults()+" documents\n");

		// Get the list of matching documents in this page of results
		MatchDocumentSummary[] results = resultsHandle.getMatchResults();
		System.out.println("Listing " + results.length + " documents:\n");
		
		// Iterate over the results
		for (MatchDocumentSummary result: results) {

			// get the list of match locations for this result
			MatchLocation[] locations = result.getMatchLocations();
			System.out.println("Matched " + locations.length + " locations in " + result.getUri() + ":");
			// iterate over the match locations
			for (MatchLocation location: locations) {

				// iterate over the snippets at a match location
				for (MatchSnippet snippet : location.getSnippets()) {
					boolean isHighlighted = snippet.isHighlighted();

					if (isHighlighted)
						System.out.print("[");
					System.out.print(snippet.getText());
					if (isHighlighted)
						System.out.print("]");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static MarkLogicDocumentSummary convertDocument(MatchDocumentSummary mlDoc) {
		MarkLogicDocumentSummary mdoc = new MarkLogicDocumentSummary(mlDoc.getUri(), mlDoc.getScore(), mlDoc.getConfidence(), mlDoc.getFitness(), mlDoc.getPath());
		ArrayList<MarkLogicLocation> locs = new ArrayList<MarkLogicLocation>();	
		for (MatchLocation location: mlDoc.getMatchLocations()) {
			MarkLogicLocation mLoc = new MarkLogicLocation(location.getPath());
			ArrayList<MarkLogicSnippet> snips = new ArrayList<MarkLogicSnippet>();
			for (MatchSnippet snippet : location.getSnippets()) {
				MarkLogicSnippet snip = new MarkLogicSnippet(snippet.isHighlighted(), snippet.getText());
				snips.add(snip);
			}
			mLoc.setSnippetList(snips);
			locs.add(mLoc);
		}
		mdoc.setLocations(locs);
		return mdoc;
	}

}
