package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.HandsOn2RestCountryWebServiceApplication;
import com.cognizant.springlearn.entity.Country;

@RestController
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HandsOn2RestCountryWebServiceApplication.class);
	
	@RequestMapping(value = "/country")
	public Country getCountryIndia() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("in", Country.class);
		
		LOGGER.info("END");
		return country;
	}

}
