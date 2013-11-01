package com.di.world.entity.MarkLogic;

public class MarkLogicSnippet {
	private boolean highlight = false;
    private String text = null;
    
    public MarkLogicSnippet(boolean high, String text) {
        this.highlight = high;
        this.text = text;
    }
	public boolean getHighlight() {
		return highlight;
	}

	public String getText() {
		return text;
	}

}
