package com.example.rest.webservices.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
//@JsonIgnoreProperties(value = {"value1","value2"})

@JsonFilter("SomeBeanFilter")
public class SomeBean {
	@JsonProperty
	private String value1;
	//@JsonIgnore
	private String value2;
	private String value3;
	
	public SomeBean(String value1, String value2, String value3) {
		super();
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}
	
	

	public String getValue1() {
		return value1;
	}



	public void setValue1(String value1) {
		this.value1 = value1;
	}



	public String getValue2() {
		return value2;
	}



	public void setValue2(String value2) {
		this.value2 = value2;
	}



	public String getValue3() {
		return value3;
	}



	public void setValue3(String value3) {
		this.value3 = value3;
	}



	@Override
	public String toString() {
		return "SomeBean [value1=" + value1 + ", value2=" + value2 + ", value3=" + value3 + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
