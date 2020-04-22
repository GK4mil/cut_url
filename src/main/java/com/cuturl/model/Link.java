package com.cuturl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity

public class Link {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	@NotNull
	String longURL;
	@NotNull
	String shortURL;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getLongURL() {
		return longURL;
	}
	public void setLongURL(String longURL) {
		this.longURL = longURL;
	}
	public String getShortURL() {
		return shortURL;
	}
	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}
	
	
}
