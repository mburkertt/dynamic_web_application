package ch.erni.webapplication.service.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.Test;

import ch.erni.webapplication.service.HtmlDocumentParserService;
import ch.erni.webapplication.service.HtmlPageUrlCrawlerService;

public class HtmlPageUrlCrawlerServiceTest {

	@Test
	public void nullCheckTestGetListWithUrlsFromWebPage() throws Exception{
		HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
		HtmlPageUrlCrawlerService htmlPageUrlCrawlerService = new HtmlPageUrlCrawlerService();
		assertNotNull(htmlPageUrlCrawlerService.getListWithUrlsFromWebPage(htmlDocumentParserServiceTest.documentBuilder("https://www.google.ch")));
	}
	
	@Test
	public void nullCheckTestGetUrlsFromAnWebpage() throws Exception{
		HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
		HtmlPageUrlCrawlerService htmlPageUrlCrawlerService = new HtmlPageUrlCrawlerService();
		List<Document> documentListTest = new ArrayList<Document>();
		documentListTest.add(htmlDocumentParserServiceTest.documentBuilder("https://www.google.ch"));
		assertNotNull(htmlPageUrlCrawlerService.getUrlsFromAnWebpage(documentListTest));
	}

}
