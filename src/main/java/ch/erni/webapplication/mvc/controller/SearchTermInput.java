package ch.erni.webapplication.mvc.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.erni.webapplication.model.DataInput;
import ch.erni.webapplication.model.PageInformationObject;
import ch.erni.webapplication.service.ModelBeanBuilderService;

@Controller
@RequestMapping(value = "/")
public class SearchTermInput {
	
	private ModelBeanBuilderService modelBeanBuilderService;
	
	@Autowired
	public SearchTermInput(ModelBeanBuilderService modelBeanBuilderService) {
		this.modelBeanBuilderService = modelBeanBuilderService;
	}
	@Resource(name = "localisationVariable")
	public String localisationVariable;
	@Resource(name = "profileVariable")
	public String profileVariable;
	
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(ModelMap model) {
        DataInput dataInput = new DataInput();    	
    	model.put("dataInput", dataInput);
    	model.put("localisationVariable", localisationVariable);
    	model.put("profileVariable", profileVariable);
        return "viewaddsearch";
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("dataInput") DataInput dataInput,
    		ModelMap model) throws Exception {
    	modelBeanBuilderService.initDataInputForValidation(dataInput.getSearchTerm(), dataInput.getUrlToCheck());
		modelBeanBuilderService.initParsedValueBean(dataInput.getSearchTerm(), dataInput.getUrlToCheck());
		Map<String, PageInformationObject> crawlingInformation = modelBeanBuilderService.getCrawlingInformation();
		crawlingInformation.remove(null);
		crawlingInformation.remove("null");
		model.put("crawlingDataMap", crawlingInformation);        
        return "viewwithsearch";
    }

}
