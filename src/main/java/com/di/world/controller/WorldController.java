package com.di.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.di.world.service.ContinentManager;

@Controller
public class WorldController {
	@Autowired
	ContinentManager continent;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listContinents(ModelMap map) {
		map.addAttribute("continentList", continent.getContinents());
		return "world";
	}

}
