package ch.erni.webapplication.service.test;

import static org.junit.Assert.*;

import org.jsoup.nodes.Document;
import org.junit.Test;

import ch.erni.webapplication.service.DocumentInspectionService;
import ch.erni.webapplication.service.HtmlDocumentParserService;

public class DocumentInspectionServiceTest {

	@Test
	public void stringAmountCheckForParsedDocumentNullTest() throws Exception{
		DocumentInspectionService documentInspectionServiceTest = new DocumentInspectionService();
		HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
		Document testDocument = htmlDocumentParserServiceTest.documentBuilder("https://www.google.ch/");
		assertNotNull(documentInspectionServiceTest.stringAmountCheckForParsedDocument(testDocument, "google"));
	}
	
	@Test
	public void stringCheckForParsedDocumentNullTest() throws Exception{
		DocumentInspectionService documentInspectionServiceTest = new DocumentInspectionService();
		HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
		Document testDocument = htmlDocumentParserServiceTest.documentBuilder("https://www.google.ch/");
		assertNotNull(documentInspectionServiceTest.stringCheckForParsedDocument(testDocument, "google"));
	}

		@Test
		public void stringAmountCheckForParsedDocumentNullSecTest() throws Exception{
			DocumentInspectionService documentInspectionServiceTest = new DocumentInspectionService();
			HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
			Document testDocument = htmlDocumentParserServiceTest.documentBuilder("https://www.google.de/intl/de/policies/terms/");
			assertNotNull(documentInspectionServiceTest.stringAmountCheckForParsedDocument(testDocument, "google"));
		}
		
		@Test
		public void stringCheckForParsedDocumentNullSecTest() throws Exception{
			DocumentInspectionService documentInspectionServiceTest = new DocumentInspectionService();
			HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
			Document testDocument = htmlDocumentParserServiceTest.documentBuilder("https://www.google.de/intl/de/policies/terms/");
			assertNotNull(documentInspectionServiceTest.stringCheckForParsedDocument(testDocument, "google"));
		}

}

