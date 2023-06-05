package com.example.rest.webservices.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserInfo {

	@Id
	@GeneratedValue
	private int Id;
	
	private String Description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
	
}
