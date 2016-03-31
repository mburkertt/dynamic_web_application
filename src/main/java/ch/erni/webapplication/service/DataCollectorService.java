package ch.erni.webapplication.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.erni.webapplication.model.PageInformationObject;

@Service
public class DataCollectorService {

	@Resource(name = "crawlingDeepness")
	public int crawlingDeepness;
	@Resource(name = "searchWords")
	public String searchWords;
	private HtmlPageUrlCrawlerService htmlPageUrlCrawler;
	private HtmlDocumentParserService htmlDocumentParser;
	private DocumentInspectionService documentInspectionService;

	@Autowired
	public DataCollectorService(HtmlPageUrlCrawlerService htmlPageUrlCrawler,
			HtmlDocumentParserService htmlDocumentParser, DocumentInspectionService documentInspectionService) {
		this.htmlPageUrlCrawler = htmlPageUrlCrawler;
		this.htmlDocumentParser = htmlDocumentParser;
		this.documentInspectionService = documentInspectionService;
	}

	public List<Document> getDocuments(List<Document> parsedHtmlDocument) throws Exception {
		Map<String, List<String>> mapWithListsOfUrls = new HashMap<String, List<String>>();
		List<String> listWithAllUrls;
		for (Document document : parsedHtmlDocument) {
			if (document != null) {
				listWithAllUrls = htmlPageUrlCrawler.getListWithUrlsFromWebPage(document);

				mapWithListsOfUrls.put(document.location(), listWithAllUrls);
			}
		}
		return htmlDocumentParser.documentListBuilder(mapWithListsOfUrls);
	}

	public List<Document> getAllDocuments(List<Document> parsedHtmlDocument, int currentDeep) throws Exception {
		if (currentDeep < crawlingDeepness) {
			currentDeep++;

			return getAllDocuments(getDocuments(parsedHtmlDocument), currentDeep);
		} else {
			return parsedHtmlDocument;
		}
	}

	public Map<String, PageInformationObject> getAllPageInformationObjectsAndPutThemInMap(
			List<Document> listWithAllDocuments, String searchTerm) {
		Map<String, PageInformationObject> mapWithAllPageInformationObjects = new HashMap<String, PageInformationObject>();
		for (Document singleDocument : listWithAllDocuments) {
			if (singleDocument != null) {
				PageInformationObject pageInformationObject = new PageInformationObject();
				pageInformationObject
						.setPageInformationObjectId(searchTerm + singleDocument.baseUri() + singleDocument.location());
				pageInformationObject.setHtmlPageDocumentInformation(singleDocument);
				pageInformationObject.setInformationAboutSearchTerm(
						documentInspectionService.stringCheckForParsedDocument(singleDocument, searchTerm));
				pageInformationObject.setInformationAboutSearchTermAmount(
						documentInspectionService.stringAmountCheckForParsedDocument(singleDocument, searchTerm));
				pageInformationObject.setSearchTerm(searchTerm);
				mapWithAllPageInformationObjects.put(searchTerm + singleDocument.baseUri() + singleDocument.location(),
						pageInformationObject);
			}
		}
		return mapWithAllPageInformationObjects;

	}

}
