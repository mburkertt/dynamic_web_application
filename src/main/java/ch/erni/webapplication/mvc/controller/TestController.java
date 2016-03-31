package ch.erni.webapplication.mvc.controller;

import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.erni.webapplication.model.DataInput;
import ch.erni.webapplication.model.PageInformationObject;
import ch.erni.webapplication.model.ParsedValueBean;
import ch.erni.webapplication.service.ModelBeanBuilderService;

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
	public String scanUrl;
	@Resource(name = "searchWords")
	public String searchWords;
	private ModelBeanBuilderService modelBeanBuilderService;


	@Autowired
	public TestController(ModelBeanBuilderService modelBeanBuilderService) {
		this.modelBeanBuilderService = modelBeanBuilderService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewJsp(ModelMap model) throws Exception {
		modelBeanBuilderService.initDataInputForValidation(searchWords, scanUrl);
		modelBeanBuilderService.initParsedValueBean(searchWords, scanUrl);
		Map<String, PageInformationObject> crawlingInformation = modelBeanBuilderService.getCrawlingInformation();
		model.put("crawlingDataMap", crawlingInformation);
		model.put("locVar", locVar);
		return "view";
	}
	
//	   @RequestMapping(value = "/search", method = RequestMethod.GET)
//	   public ModelAndView dataInput() {
//	      return new ModelAndView("datainput", "command", new DataInput());
//	   }
//	
//		   @RequestMapping(value = "/addSearch", method = RequestMethod.POST)
//		   public String addSearch(@ModelAttribute("SpringWeb")DataInput dataInput, 
//		   ModelMap model) {
//			    model.addAttribute("searchTerm", dataInput.getSearchTerm());
//			    model.addAttribute("urlToCheck", dataInput.getUrlToCheck());
//				modelBeanBuilderService.initDataInputForValidation(dataInput.getSearchTerm(), dataInput.getUrlToCheck());
//				modelBeanBuilderService.initParsedValueBean(dataInput.getSearchTerm(), dataInput.getUrlToCheck());
//				Map<String, PageInformationObject> crawlingInformation = modelBeanBuilderService.getCrawlingInformation();
//				model.put("crawlingDataMap", crawlingInformation);
//		return "viewWithSearch";
//	}

}
