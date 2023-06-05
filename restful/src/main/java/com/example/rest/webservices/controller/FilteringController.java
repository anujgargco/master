package com.example.rest.webservices.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.webservices.bean.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue getValue() {
		SomeBean someBean =new SomeBean("value1","value2","value3");
		MappingJacksonValue jacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("value2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		jacksonValue.setFilters(filters);
		return jacksonValue;
	}
}
