package ch.erni.webapplication.mvc.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.erni.webapplication.service.HtmlDocumentParser;

/**
 * 
 * @author mburkert
 *
 */
@Controller
public class TestController {

	@Resource(name = "locale")
	public Locale locVar;
	
	@Resource(name = "scanUrl")
	public List<String> scanUrl;
	
	@Resource(name = "searchWords")
	public List<String> searchWords;

	private HtmlDocumentParser documentParser;

	@Autowired
	public TestController(HtmlDocumentParser documentParser) {
		this.documentParser = documentParser;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewJsp(ModelMap model) throws Exception {
		Map<String,Boolean> stringCheckOfHtmlDocument = documentParser.stringCheckForParsedDocument(documentParser.getADocumentOutOfAHtmlPage(scanUrl), searchWords);
		model.put("stringCheck", stringCheckOfHtmlDocument);
		model.put("locVar", locVar);
		return "view";
	}
	
	@RequestMapping(value = "/failed", method = RequestMethod.POST)
	public String viewFailedRefresh(ModelMap model, @RequestParam(value = "locVar", required = true) String locVar)
			throws Exception {
		model.put("locVar", locVar);
		return "view";
	}

}
