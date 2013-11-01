package com.di.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.di.world.service.ContinentManager;
import com.di.world.service.CurrencyManager;

@Controller
@RequestMapping(value = "/currency")
public class CurrencyController {
	@Autowired
	CurrencyManager manager;
	@Autowired
	ContinentManager continent;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCurrency(ModelMap map) {
		map.addAttribute("currencyList", manager.getCurrency());
		map.addAttribute("continentList", continent.getContinents());
		return "currency";
	}

}
