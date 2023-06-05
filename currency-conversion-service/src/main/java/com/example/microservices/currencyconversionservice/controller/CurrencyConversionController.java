package com.example.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservices.currencyconversionservice.bean.CurrencyConversion;
import com.example.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	public Environment env;
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		Map<String,String>uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> entity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class,uriVariables);
		CurrencyConversion conversion =entity.getBody();
		return new CurrencyConversion(conversion.getId(),from,to,conversion.getConversionMultiple(),quantity,quantity.multiply(conversion.getConversionMultiple()),conversion.getEnvironment());
		
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFiegn(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		CurrencyConversion conversion =proxy.getExchangeDetails(from, to);
		return new CurrencyConversion(conversion.getId(),from,to,conversion.getConversionMultiple(),quantity,quantity.multiply(conversion.getConversionMultiple()),conversion.getEnvironment());
		
	}
	

}
