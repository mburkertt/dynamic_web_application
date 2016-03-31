package ch.erni.webapplication.service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.junit.Test;

import ch.erni.webapplication.model.PageInformationObject;
import ch.erni.webapplication.service.DataCollectorService;
import ch.erni.webapplication.service.DocumentInspectionService;
import ch.erni.webapplication.service.HtmlDocumentParserService;
import ch.erni.webapplication.service.HtmlPageUrlCrawlerService;

public class DataCollectorServiceTest {

	@Test
	public void getDocumentsNullCheckTest() throws Exception{
		HtmlPageUrlCrawlerService htmlPageUrlCrawler = new HtmlPageUrlCrawlerService();
		HtmlDocumentParserService htmlDocumentParser = new HtmlDocumentParserService();
		DocumentInspectionService documentInspectionService = new DocumentInspectionService();
		DataCollectorService datacollecterServiceTest = new DataCollectorService(htmlPageUrlCrawler, htmlDocumentParser, documentInspectionService);
		HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
		Document testDocument = htmlDocumentParserServiceTest.documentBuilder("https://www.google.ch/");
		List<Document> testListDocument = new ArrayList<Document>();
		testListDocument.add(testDocument);
		assertNotNull(datacollecterServiceTest.getAllDocuments(testListDocument, 2));
	}
	
	@Test
	public void getAllDocumentsNullCheckTest() throws Exception{
		HtmlPageUrlCrawlerService htmlPageUrlCrawler = new HtmlPageUrlCrawlerService();
		HtmlDocumentParserService htmlDocumentParser = new HtmlDocumentParserService();
		DocumentInspectionService documentInspectionService = new DocumentInspectionService();
		DataCollectorService datacollecterServiceTest = new DataCollectorService(htmlPageUrlCrawler, htmlDocumentParser, documentInspectionService);
		HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
		Document testDocument = htmlDocumentParserServiceTest.documentBuilder("https://www.google.ch/");
		List<Document> testListDocument = new ArrayList<Document>();
		testListDocument.add(testDocument);
		assertNotNull(datacollecterServiceTest.getAllDocuments(testListDocument, 2));
	}

	@Test
	public void getAllPageInformationObjectsAndPutThemInMapNullCheckTest() throws Exception{
	HtmlPageUrlCrawlerService htmlPageUrlCrawler = new HtmlPageUrlCrawlerService();
	HtmlDocumentParserService htmlDocumentParser = new HtmlDocumentParserService();
	DocumentInspectionService documentInspectionService = new DocumentInspectionService();
	DataCollectorService datacollecterServiceTest = new DataCollectorService(htmlPageUrlCrawler, htmlDocumentParser, documentInspectionService);
		HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
		Document testDocument = htmlDocumentParserServiceTest.documentBuilder("https://www.google.ch/");
		List<Document> testListDocument = new ArrayList<Document>();
		testListDocument.add(testDocument);
		assertNotNull(datacollecterServiceTest.getAllPageInformationObjectsAndPutThemInMap(testListDocument, "google"));
		
	}
	
	@Test
	public void getAllPageInformationObjectsAndPutThemInMapSearchTestTrueTest() throws Exception{
	HtmlPageUrlCrawlerService htmlPageUrlCrawler = new HtmlPageUrlCrawlerService();
	HtmlDocumentParserService htmlDocumentParser = new HtmlDocumentParserService();
	DocumentInspectionService documentInspectionService = new DocumentInspectionService();
	DataCollectorService datacollecterServiceTest = new DataCollectorService(htmlPageUrlCrawler, htmlDocumentParser, documentInspectionService);
		HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
		Document testDocument = htmlDocumentParserServiceTest.documentBuilder("https://www.google.ch/");
		List<Document> testListDocument = new ArrayList<Document>();
		testListDocument.add(testDocument);
		Map<String, PageInformationObject> testListObject = datacollecterServiceTest.getAllPageInformationObjectsAndPutThemInMap(testListDocument, "google");
		assertTrue(testListObject.values().iterator().next().getInformationAboutSearchTerm());		
	}
	
	@Test
	public void getAllPageInformationObjectsAndPutThemInMapSearchTestFalseTest() throws Exception{
	HtmlPageUrlCrawlerService htmlPageUrlCrawler = new HtmlPageUrlCrawlerService();
	HtmlDocumentParserService htmlDocumentParser = new HtmlDocumentParserService();
	DocumentInspectionService documentInspectionService = new DocumentInspectionService();
	DataCollectorService datacollecterServiceTest = new DataCollectorService(htmlPageUrlCrawler, htmlDocumentParser, documentInspectionService);
		HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
		Document testDocument = htmlDocumentParserServiceTest.documentBuilder("https://www.google.ch/");
		List<Document> testListDocument = new ArrayList<Document>();
		testListDocument.add(testDocument);
		Map<String, PageInformationObject> testListObject = datacollecterServiceTest.getAllPageInformationObjectsAndPutThemInMap(testListDocument, "matthias");
		assertFalse(testListObject.values().iterator().next().getInformationAboutSearchTerm());	
	}
	
	@Test
	public void getAllPageInformationObjectsAndPutThemInMapSearchWordCounterNotMatchTest() throws Exception{
	HtmlPageUrlCrawlerService htmlPageUrlCrawler = new HtmlPageUrlCrawlerService();
	HtmlDocumentParserService htmlDocumentParser = new HtmlDocumentParserService();
	DocumentInspectionService documentInspectionService = new DocumentInspectionService();
	DataCollectorService datacollecterServiceTest = new DataCollectorService(htmlPageUrlCrawler, htmlDocumentParser, documentInspectionService);
		HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
		Document testDocument = htmlDocumentParserServiceTest.documentBuilder("https://www.google.ch/");
		List<Document> testListDocument = new ArrayList<Document>();
		testListDocument.add(testDocument);
		Map<String, PageInformationObject> testListObject = datacollecterServiceTest.getAllPageInformationObjectsAndPutThemInMap(testListDocument, "matthias");
		assertEquals(new Long(0), new Long(testListObject.values().iterator().next().getInformationAboutSearchTermAmount()));
	}
	
	@Test
	public void getAllPageInformationObjectsAndPutThemInMapSearchWordCounterMatchTest() throws Exception{
	HtmlPageUrlCrawlerService htmlPageUrlCrawler = new HtmlPageUrlCrawlerService();
	HtmlDocumentParserService htmlDocumentParser = new HtmlDocumentParserService();
	DocumentInspectionService documentInspectionService = new DocumentInspectionService();
	DataCollectorService datacollecterServiceTest = new DataCollectorService(htmlPageUrlCrawler, htmlDocumentParser, documentInspectionService);
		HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
		Document testDocument = htmlDocumentParserServiceTest.documentBuilder("https://www.google.ch/");
		List<Document> testListDocument = new ArrayList<Document>();
		testListDocument.add(testDocument);
		Map<String, PageInformationObject> testListObject = datacollecterServiceTest.getAllPageInformationObjectsAndPutThemInMap(testListDocument, "google");
		assertNotEquals(new Long(0), new Long(testListObject.values().iterator().next().getInformationAboutSearchTermAmount()));
	}
}
