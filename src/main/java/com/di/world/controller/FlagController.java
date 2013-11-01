package com.di.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.di.world.service.ContinentManager;
import com.di.world.service.FlagManager;

@Controller
@RequestMapping(value = "/flag")
public class FlagController {
	@Autowired
	FlagManager manager;
	@Autowired
	ContinentManager continent;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(ModelMap map) {
		map.addAttribute("flagList", manager.getFlags());
		map.addAttribute("continentList", continent.getContinents());
		return "flag";
	}

}
