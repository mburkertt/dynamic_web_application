package ch.erni.webapplication.service;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 
 * @author buma
 *
 */
@Service
public class DocumentInspectionService {
	
	public int stringAmountCheckForParsedDocument(Document singleDocument, String termToCheck){
		return StringUtils.countOccurrencesOf(singleDocument.toString(), termToCheck);
	}
	
	public Boolean stringCheckForParsedDocument(Document singleDocument, String termToCheck){
		return singleDocument.toString().contains(termToCheck);
	}

}
