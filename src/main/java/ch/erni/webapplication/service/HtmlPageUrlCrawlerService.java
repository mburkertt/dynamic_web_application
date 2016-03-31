package ch.erni.webapplication.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class HtmlPageUrlCrawlerService {
	
	public List<String> getListWithUrlsFromWebPage(Document parsedHtmlDocument){
		String crawledUri;
		List<String> listWithBaseUriAndAllPossibleUrisThere = new ArrayList<String>();
		Elements links = parsedHtmlDocument. select("a");
		for (Element link : links) {
			crawledUri = link.absUrl("href");
			listWithBaseUriAndAllPossibleUrisThere.add(crawledUri);
		}
		return listWithBaseUriAndAllPossibleUrisThere;
	}
		
	public Map<String, List<String>> getUrlsFromAnWebpage(List<Document> parsedHtmlDocuments) {
		Map<String, List<String>> MapWithListWithBaseUriAndAllPossibleUrisThere = new HashMap<String, List<String>>();
		for (Document parsedHtmlDocument : parsedHtmlDocuments) {
			MapWithListWithBaseUriAndAllPossibleUrisThere.put(parsedHtmlDocument.baseUri(), getListWithUrlsFromWebPage(parsedHtmlDocument));
		}
		return MapWithListWithBaseUriAndAllPossibleUrisThere;
	}
	
}
