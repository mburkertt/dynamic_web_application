package ch.erni.webapplication.model;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ParsedValueBean {
	
	private Map<String, PageInformationObject> crawlingInformationBean;

	public Map<String , PageInformationObject> getCrawlingInformationBean() {
		return crawlingInformationBean;
	}

	public void setCrawlingInformationBean(Map<String, PageInformationObject> crawlingInformationBean) {
		this.crawlingInformationBean = crawlingInformationBean;
	}	
}
