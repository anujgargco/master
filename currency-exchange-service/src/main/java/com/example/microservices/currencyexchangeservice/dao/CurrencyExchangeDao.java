package com.example.microservices.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeDao extends JpaRepository<CurrencyExchange, Long> {
	
	CurrencyExchange findByFromAndTo(String from, String to);

}
