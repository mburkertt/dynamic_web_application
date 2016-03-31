package ch.erni.webapplication.model;

import org.springframework.stereotype.Component;

@Component
public class DataInputForValidation {

	
	private String searchTerm;
	private String searchStartUrl;
	public String getSearchTerm() {
		return searchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	public String getSearchStartUrl() {
		return searchStartUrl;
	}
	public void setSearchStartUrl(String searchStartUrl) {
		this.searchStartUrl = searchStartUrl;
	}
	
}
