package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;

@RestController
public class CountryController {
	
	@Autowired
    private ApplicationContext context;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
   
        
	@GetMapping("/countries")
	public ArrayList<Country> getAllCountries()
	{
		LOGGER.info("START GET COUNTRY");
    	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    	
        LOGGER.info("END GET COUNTRY");
        return (ArrayList<Country>) context.getBean("countryList");

	}
    @RequestMapping("/country")
    public Country getCountryIndia() {
    	LOGGER.info("START GET COUNTRY");
    	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    	
        LOGGER.info("END GET COUNTRY");
        return context.getBean("country", Country.class);
    }

}
