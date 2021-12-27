package com.hongxun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/foodDetail", method = RequestMethod.GET)
	public String foodDetail() {
		return "index";
	}

	@RequestMapping(value = "/termsAndConditions", method = RequestMethod.GET)
	public String termsAndConditions() {
		return "termsAndConditions";
	}

	@RequestMapping(value = "/privacy", method = RequestMethod.GET)
	public String privacy() {
		return "privacy";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "contact";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		return "about";
	}
	
	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String help() {
		return "help";
	}
}