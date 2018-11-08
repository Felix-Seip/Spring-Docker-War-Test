package com.prostep.examples;

public class InfoObject {

	private String applicationName;
	private String author;
	private String lastModified;
	private String description;

	/*
	 * GETTERS
	 * */
	public String getApplicationName() {
		return applicationName;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getLastModified() {
		return lastModified;
	}
	
	public String getDescription() {
		return description;
	}

	/*
	 * SETTERS
	 * */
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
}
