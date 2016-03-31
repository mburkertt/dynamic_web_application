package ch.erni.webapplication.service.test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import ch.erni.webapplication.model.DataInputForValidation;
import ch.erni.webapplication.model.PageInformationObject;
import ch.erni.webapplication.model.ParsedValueBean;
import ch.erni.webapplication.service.DataCollectorService;
import ch.erni.webapplication.service.DocumentInspectionService;
import ch.erni.webapplication.service.HtmlDocumentParserService;
import ch.erni.webapplication.service.HtmlPageUrlCrawlerService;
import ch.erni.webapplication.service.ModelBeanBuilderService;

public class ModelBeanBuilderServiceTest {


	@Test
	public void getCrawlingInformationNullTest() throws Exception{
		ParsedValueBean parsedValueBean = new ParsedValueBean();
		HtmlDocumentParserService htmlDocumentParser = new HtmlDocumentParserService();
		HtmlPageUrlCrawlerService htmlPageUrlCrawler = new HtmlPageUrlCrawlerService();
		DocumentInspectionService documentInspectionService = new DocumentInspectionService(); 
		DataCollectorService dataCollector = new DataCollectorService(htmlPageUrlCrawler, htmlDocumentParser, documentInspectionService);
		DataInputForValidation dataInputForValidation = new DataInputForValidation();
		ModelBeanBuilderService modelBeanBuilderService = new ModelBeanBuilderService(parsedValueBean, htmlDocumentParser, dataCollector, dataInputForValidation);
		modelBeanBuilderService.initParsedValueBean("google", "https://www.google.ch");
		assertNotNull(modelBeanBuilderService.getCrawlingInformation());
	}
	
	@Test
	public void getCrawlingInformationInternalnetNullTest() throws Exception{
		ParsedValueBean parsedValueBean = new ParsedValueBean();
		HtmlDocumentParserService htmlDocumentParser = new HtmlDocumentParserService();
		HtmlPageUrlCrawlerService htmlPageUrlCrawler = new HtmlPageUrlCrawlerService();
		DocumentInspectionService documentInspectionService = new DocumentInspectionService(); 
		DataCollectorService dataCollector = new DataCollectorService(htmlPageUrlCrawler, htmlDocumentParser, documentInspectionService);
		DataInputForValidation dataInputForValidation = new DataInputForValidation();
		ModelBeanBuilderService modelBeanBuilderService = new ModelBeanBuilderService(parsedValueBean, htmlDocumentParser, dataCollector, dataInputForValidation);
		modelBeanBuilderService.initParsedValueBean("friedrich", "https://sps2010.erninet.ch/news/Pages/NewsHome.aspx");
		assertNotNull(modelBeanBuilderService.getCrawlingInformation());
	}
	
	
}
