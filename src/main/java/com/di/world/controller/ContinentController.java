package com.di.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.di.world.entity.CountryInfoEntity;
import com.di.world.service.ContinentManager;
import com.di.world.service.CountryManager;

@Controller
@RequestMapping(value = "/continent")
public class ContinentController {
	@Autowired
	ContinentManager continent;
	@Autowired
	CountryManager country;
	
	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public String listContinents(ModelMap map, @PathVariable String code) {
		map.addAttribute("countryList", continent.getCountriesFromContinent(code));
		map.addAttribute("continentInfo", continent.getContinent(code));
		map.addAttribute("continentList", continent.getContinents());
		return "continent";
	}
	
	@RequestMapping(value = "/country/{code}", method = RequestMethod.GET) 
	public String getCountry(ModelMap map, @PathVariable String code) {
		CountryInfoEntity cie = country.getInfo(code);
		map.addAttribute("countryInfo", cie);
		map.addAttribute("continentInfo", continent.getContinent(cie.getContinentCode()));
		map.addAttribute("continentList", continent.getContinents());
		map.addAttribute("countryList", continent.getCountriesFromContinent(cie.getContinentCode()));
		return "country";
	}

}
