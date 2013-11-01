package com.di.world.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Languages")
public class LanguageListEntity {
	private List<LanguageEntity> languages = new ArrayList<LanguageEntity>();

	@XmlElement(name = "tLanguage", type = LanguageEntity.class)
	public List<LanguageEntity> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguageEntity> languages) {
		this.languages = languages;
	}
	
	

}
