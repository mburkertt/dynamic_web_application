package ch.erni.webapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.erni.webapplication.model.DataInputForValidation;
import ch.erni.webapplication.model.PageInformationObject;
import ch.erni.webapplication.model.ParsedValueBean;

/**
 * 
 * @author buma
 *
 */
@Service
public class ModelBeanBuilderService {

	private ParsedValueBean parsedValueBean;
	private HtmlDocumentParserService htmlDocumentParser;
	private DataCollectorService dataCollector;
	private DataInputForValidation dataInputForValidation;

	@Autowired
	public ModelBeanBuilderService(ParsedValueBean parsedValueBean, HtmlDocumentParserService htmlDocumentParser,
			DataCollectorService dataCollector, DataInputForValidation dataInputForValidation) {
		this.parsedValueBean = parsedValueBean;
		this.htmlDocumentParser = htmlDocumentParser;
		this.dataCollector = dataCollector;
		this.dataInputForValidation = dataInputForValidation;
	}

	public void initParsedValueBean(String searchTerm, String startNodeUrl) throws Exception {
		List<Document> collectionOfAllDocuments = new ArrayList<Document>();
		Document initialDocumentCollection = htmlDocumentParser.documentBuilder(startNodeUrl);
		if (initialDocumentCollection != null) {
			collectionOfAllDocuments.add(initialDocumentCollection);
			collectionOfAllDocuments = dataCollector.getAllDocuments(collectionOfAllDocuments, 0);
			collectionOfAllDocuments.add(initialDocumentCollection);

			Map<String, PageInformationObject> crawlingInformationBean = dataCollector
					.getAllPageInformationObjectsAndPutThemInMap(collectionOfAllDocuments, searchTerm);
			parsedValueBean.setCrawlingInformationBean(crawlingInformationBean);
		}
	}

	public void initDataInputForValidation(String searchTerm, String startNodeUrl) {
		dataInputForValidation.setSearchStartUrl(startNodeUrl);
		dataInputForValidation.setSearchTerm(searchTerm);
	}
	
	public Map<String, PageInformationObject> getCrawlingInformation(){
		return parsedValueBean.getCrawlingInformationBean();
		
	}
}
