package ch.erni.webapplication.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class HtmlDocumentParser {

	@Resource(name = "scanUrl")
	public List<String> scanUrl;

	@Resource(name = "searchWords")
	public List<String> searchWords;

	public Map<String, Boolean> stringCheckForParsedDocument(List<Document> parsedHtmlDocument, List<String> textToSearch) {
		Elements checkElement = null;
		Map<String,Boolean> mapWithBaseUrlAndInformationIfCheckedStringIsIncluded = new HashMap<String,Boolean>();
		boolean hasTheSearchedWord = false;
		for (String wordWichShouldSearchedInTheHtmlText : textToSearch) {
			for (Document currentDocumentFromList : parsedHtmlDocument) {
				String currentDocumentAsString = currentDocumentFromList.toString();
				hasTheSearchedWord = currentDocumentFromList.toString().contains(wordWichShouldSearchedInTheHtmlText);
				 String baseUri = currentDocumentFromList.baseUri();				 
				mapWithBaseUrlAndInformationIfCheckedStringIsIncluded.put(currentDocumentFromList.baseUri(), hasTheSearchedWord);
			}
		}
		return mapWithBaseUrlAndInformationIfCheckedStringIsIncluded;
	}

	public List<Document> getADocumentOutOfAHtmlPage(List<String> scanUrl) throws IOException {
		List<Document> listWithHtmlDocuments = new ArrayList<Document>();
		Document doc = null;
		for (String urlToScan : scanUrl) {
			doc = Jsoup.connect(urlToScan).get();
			listWithHtmlDocuments.add(doc);
		}
		return listWithHtmlDocuments;
	}
	
}
