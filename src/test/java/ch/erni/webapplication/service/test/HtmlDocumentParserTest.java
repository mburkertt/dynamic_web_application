package ch.erni.webapplication.service.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.junit.Test;

import ch.erni.webapplication.service.HtmlDocumentParser;

public class HtmlDocumentParserTest {

	@Test
	public void functionalityNullTestGetADocumentOutOfAHtmlPage() throws IOException {
		HtmlDocumentParser testee = new HtmlDocumentParser();
		List<String> scanUrl = new ArrayList<String>();
		scanUrl.add("https://sps2010.erninet.ch/news/Pages/NewsHome.aspx");
		List<Document> htmlDocument = testee.getADocumentOutOfAHtmlPage(scanUrl);
		assertNotNull(htmlDocument);
	}

	@Test
	public void functionalityNullTestStringCheckForParsedDocument() throws IOException {
		HtmlDocumentParser testee = new HtmlDocumentParser();
		List<String> scanUrl = new ArrayList<String>();
		scanUrl.add("https://sps2010.erninet.ch/news/Pages/NewsHome.aspx");
		List<String> searchWords = new ArrayList<String>();
		searchWords.add("Matthias Burkert");
		List<Document> htmlDocument = testee.getADocumentOutOfAHtmlPage(scanUrl);
		Map<String, Boolean> mapWithUrlAndTheResultIfTheCheckedWordIsIncluded = testee
				.stringCheckForParsedDocument(htmlDocument, searchWords);
		assertNotNull(mapWithUrlAndTheResultIfTheCheckedWordIsIncluded);
	}

	@Test
	public void functionalityControllFalseCaseTestStringCheckForParsedDocument() throws IOException {
		HtmlDocumentParser testee = new HtmlDocumentParser();
		List<String> scanUrl = new ArrayList<String>();
		scanUrl.add("https://www.google.de/");
		List<String> searchWords = new ArrayList<String>();
		searchWords.add("Matthias Burkert");
		List<Document> htmlDocument = testee.getADocumentOutOfAHtmlPage(scanUrl);
		Map<String, Boolean> mapWithUrlAndTheResultIfTheCheckedWordIsIncluded = testee
				.stringCheckForParsedDocument(htmlDocument, searchWords);
		assertFalse(mapWithUrlAndTheResultIfTheCheckedWordIsIncluded.values().iterator().next());
	}
	
	@Test
	public void functionalityControllTrueCaseTestStringCheckForParsedDocument() throws IOException {
		HtmlDocumentParser testee = new HtmlDocumentParser();
		List<String> scanUrl = new ArrayList<String>();
		scanUrl.add("https://sps2010.erninet.ch/news/Pages/NewsHome.aspx");
		List<String> searchWords = new ArrayList<String>();
		searchWords.add("Matthias Burkert");
		List<Document> htmlDocument = testee.getADocumentOutOfAHtmlPage(scanUrl);
		Map<String, Boolean> mapWithUrlAndTheResultIfTheCheckedWordIsIncluded = testee
				.stringCheckForParsedDocument(htmlDocument, searchWords);
		assertTrue(mapWithUrlAndTheResultIfTheCheckedWordIsIncluded.values().iterator().next());
	}

}
