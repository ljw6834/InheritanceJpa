package com.aaa.model;

import java.time.LocalDateTime;

public class SearchRequest {
     private String author;
     private LocalDateTime start;
     private LocalDateTime end; 
     private String country;
     
     
	public SearchRequest(String author, LocalDateTime start, LocalDateTime end, String country) {
		super();
		this.author = author;
		this.start = start;
		this.end = end;
		this.country = country;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public LocalDateTime getStart() {
		return start;
	}


	public void setStart(LocalDateTime start) {
		this.start = start;
	}


	public LocalDateTime getEnd() {
		return end;
	}


	public void setEnd(LocalDateTime end) {
		this.end = end;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	} 
	
}
