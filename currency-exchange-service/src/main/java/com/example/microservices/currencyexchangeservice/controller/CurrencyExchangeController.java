package com.example.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.example.microservices.currencyexchangeservice.dao.CurrencyExchangeDao;

@RestController
public class CurrencyExchangeController {
	private Logger logger =LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeDao exchangeDao;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getExchangeDetails(@PathVariable String from, @PathVariable String to) {
		
		String environment =env.getProperty("local.server.port");
		CurrencyExchange currencyExchange = exchangeDao.findByFromAndTo(from, to);
		currencyExchange.setEnvironment(environment);
		return currencyExchange;
		
	}

}
