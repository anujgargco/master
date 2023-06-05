package com.example.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private Long Id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	
	
	public CurrencyConversion() {}
	
	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple,
			BigDecimal quantity, BigDecimal totalCalculatedAmount, String environment) {
		super();
		Id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.environment = environment;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "CurrencyConversion [Id=" + Id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", environment=" + environment + ", quantity=" + quantity
				+ ", totalCalculatedAmount=" + totalCalculatedAmount + "]";
	}

	

}
