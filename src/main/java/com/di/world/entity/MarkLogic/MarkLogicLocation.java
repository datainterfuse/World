package com.di.world.entity.MarkLogic;

import java.util.ArrayList;

public class MarkLogicLocation  {
	private String path = null;
    private ArrayList<MarkLogicSnippet> snippets = new ArrayList<MarkLogicSnippet>();

	public MarkLogicLocation(String path) {
		this.path = path;
	}
    
    public String getPath() {
		return path;
	}
	
	public ArrayList<MarkLogicSnippet> getSnippets() {
		return snippets;
	}
	
	public void setSnippet(MarkLogicSnippet snippet) {
		snippets.add(snippet);
	}
	
	public void setSnippetList(ArrayList<MarkLogicSnippet> snippets) {
		this.snippets = snippets;
	}

}
