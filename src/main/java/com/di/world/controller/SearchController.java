package com.di.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.di.world.service.ContinentManager;
import com.di.world.service.SearchManager;

@Controller
@RequestMapping(value = "/search")
public class SearchController {
	@Autowired
	SearchManager manager;
	@Autowired
	ContinentManager continent;
	
	
	@RequestMapping(method = RequestMethod.GET) 
	public String search(ModelMap map) {
		map.addAttribute("value", "");
		map.addAttribute("continentList", continent.getContinents());
		return "search";
	}
	
	@RequestMapping(value = "/{value}", method = RequestMethod.GET) 
	public String searchStringValue(ModelMap map, @PathVariable String value) {
		map.addAttribute("searchResults", manager.SearchStringHandler(value));
		map.addAttribute("value", value);
		map.addAttribute("continentList", continent.getContinents());
		return "search";
	}
	
	@RequestMapping(value = "/pair/{element}/{value}", method = RequestMethod.GET) 
	public String search(ModelMap map, @PathVariable String element, @PathVariable String value) {
		map.addAttribute("searchResults", manager.searchMarkLogicElementValue(element, value));
		map.addAttribute("value", value);
		map.addAttribute("continentList", continent.getContinents());
		return "search";
	}
	

}
