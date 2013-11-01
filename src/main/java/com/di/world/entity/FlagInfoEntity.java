package com.di.world.entity;

public class FlagInfoEntity implements Comparable<FlagInfoEntity>{
	private String name;
	private String code;
	private String link;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public int compareTo(FlagInfoEntity o) {
		return name.compareTo(o.getName());
	}
	
	

}
