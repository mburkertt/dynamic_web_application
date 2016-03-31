package ch.erni.webapplication.service.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import ch.erni.webapplication.service.HtmlDocumentParserService;

public class HtmlDocumentParserServiceTest {
	
	@Test
	public void documentBuilderNullTest() throws Exception{
		HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
		assertNotNull(htmlDocumentParserServiceTest.documentBuilder("https://www.google.ch"));
	}
	
	@Test
	public void documentListBuilderNullTest() throws Exception{
		HtmlDocumentParserService htmlDocumentParserServiceTest = new HtmlDocumentParserService();
		Map<String, List<String>> testMap = new HashMap<String, List<String>>();
		List<String> testLinkList = new ArrayList<String>();
		testLinkList.add("https://www.google.ch");
		testMap.put("https://www.google.ch", testLinkList);
		assertNotNull(htmlDocumentParserServiceTest.documentListBuilder(testMap));
	}

}
