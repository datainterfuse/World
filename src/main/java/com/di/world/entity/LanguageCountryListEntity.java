package com.di.world.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LanguageCountryListEntity {
	private List<LanguageInfoEntity> languages = new ArrayList<LanguageInfoEntity>();

	public List<LanguageInfoEntity> getLanguages() {
		Collections.sort(languages);
		return languages;
	}

	public void setLanguages(List<LanguageInfoEntity> languages) {
		this.languages = languages;
	}
	
}
