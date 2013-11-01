package com.di.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.di.world.service.ContinentManager;
import com.di.world.service.LanguageManager;

@Controller
@RequestMapping(value = "/language")
public class LanguageController {
	@Autowired
	LanguageManager manager;
	@Autowired
	ContinentManager continent;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLanguages(ModelMap map) {
		map.addAttribute("languageList", manager.getLanguages());
		map.addAttribute("continentList", continent.getContinents());
		return "language";
	}

}
