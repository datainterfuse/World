package com.di.world.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.media.sound.ModelMappedInstrument;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getTest(ModelMap map) {
		return "test";
	}

}
