package ch.erni.webapplication.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

import java.io.OutputStream; 

import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class HtmlDocumentParserService {

	org.slf4j.Logger logger;

	public Document documentBuilder(String documentBaseUrl) throws Exception {
		Document doc = null;
		UrlValidator urlValidator = new UrlValidator();
			if (urlValidator.isValid(documentBaseUrl)) {
				URL urlForConnectionCheck = new URL(documentBaseUrl);
				HttpURLConnection connection = (HttpURLConnection) urlForConnectionCheck.openConnection();
				if (urlValidator.isValid(documentBaseUrl) 
						&& connection != null
						&& documentBaseUrl.contains(".pdf") == false
						&& documentBaseUrl.contains(".pl") == false
						&& documentBaseUrl.contains(".mp4") == false
						&& connection.getResponseCode() == 200) {
					doc = Jsoup.connect(documentBaseUrl).get();
				}
			}
		return doc;
	}

	public List<Document> documentListBuilder(Map<String, List<String>> listWithBaseUrlAndAllContainingUrl) throws Exception {
		List<Document> crawledUrlsAsDocuments = new ArrayList<Document>();
		for (String keyforTheMap : listWithBaseUrlAndAllContainingUrl.keySet()) {
			List<String> listWithUrls = listWithBaseUrlAndAllContainingUrl.get(keyforTheMap);
			for (String pageUrl : listWithUrls) {
 				UrlValidator urlValidator = new UrlValidator();
				if (pageUrl != null 
						&& pageUrl.isEmpty() == false 
						&& urlValidator.isValid(pageUrl) 
						&& pageUrl != keyforTheMap
						&& documentBuilder(pageUrl) != null) {
					crawledUrlsAsDocuments.add(documentBuilder(pageUrl));
				}
			}
		}
		return crawledUrlsAsDocuments;
	}
	

}
