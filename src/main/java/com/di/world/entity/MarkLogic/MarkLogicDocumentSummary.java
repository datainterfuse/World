package com.di.world.entity.MarkLogic;

import java.util.ArrayList;

import org.w3c.dom.Document;

import com.marklogic.client.query.MatchDocumentSummary;
import com.marklogic.client.query.MatchLocation;

public class MarkLogicDocumentSummary {
	private String uri = null;
    private int score = -1;
    private double confidence = -1;
    private double fitness = -1;
    private String path = null;
    private ArrayList<MarkLogicLocation> locations = new ArrayList<MarkLogicLocation>();
    private Document metadata = null;

	public MarkLogicDocumentSummary(String uri, int score, double confidence, double fitness, String path) {
		this.uri = uri;
        this.score = score;
        this.confidence = confidence;
        this.fitness = fitness;
        this.path = path;
	}
    
    public String getUri() {
		return uri;
	}

	public int getScore() {
		return score;
	}

	public double getConfidence() {
		return confidence;
	}

	public double getFitness() {
		return fitness;
	}

	public String getPath() {
		return path;
	}

	public MatchLocation[] getMatchLocations() {
		 return null;
	}
	
	public void setLocations(MarkLogicLocation location) {
		this.locations.add(location);
	}
	
	public void setLocations(ArrayList<MarkLogicLocation> locations) {
		this.locations = locations;
	}
	
	public ArrayList<MarkLogicLocation> getLocations() {
		return locations;
	}

	public Document[] getSnippets() {
		// TODO Auto-generated method stub
		return null;
	}

	public Document getMetadata() {
		return metadata;
	}

}
