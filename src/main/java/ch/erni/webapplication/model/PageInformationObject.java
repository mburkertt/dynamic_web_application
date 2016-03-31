package ch.erni.webapplication.model;

import org.jsoup.nodes.Document;

public class PageInformationObject {
	
	private String pageInformationObjectId;
	private Document htmlPageDocumentInformation;	
	private Boolean informationAboutSearchTerm;	
	private int informationAboutSearchTermAmount;
	private String searchTerm;

	public String getPageInformationObjectId() {
		return pageInformationObjectId;
	}

	public void setPageInformationObjectId(String pageInformationObjectId) {
		this.pageInformationObjectId = pageInformationObjectId;
	}

	public Document getHtmlPageDocumentInformation() {
		return htmlPageDocumentInformation;
	}

	public void setHtmlPageDocumentInformation(Document htmlPageDocumentInformation) {
		this.htmlPageDocumentInformation = htmlPageDocumentInformation;
	}

	public Boolean getInformationAboutSearchTerm() {
		return informationAboutSearchTerm;
	}

	public void setInformationAboutSearchTerm(Boolean informationAboutSearchTerm) {
		this.informationAboutSearchTerm = informationAboutSearchTerm;
	}

	public int getInformationAboutSearchTermAmount() {
		return informationAboutSearchTermAmount;
	}

	public void setInformationAboutSearchTermAmount(int informationAboutSearchTermAmount) {
		this.informationAboutSearchTermAmount = informationAboutSearchTermAmount;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

}
