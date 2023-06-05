package com.example.microservices.limitservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.limitservices.bean.Limits;
import com.example.microservices.limitservices.config.LimitConfig;

@RestController
public class LimitsController {
	@Autowired
	private LimitConfig limitConfig;

	@GetMapping("/limits")
	public Limits reteriveLimits() {
		return new Limits(limitConfig.getMinimum(),limitConfig.getMaximum());
	//	return new Limits(1,1000);
	}
}
