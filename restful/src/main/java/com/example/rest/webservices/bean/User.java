package com.example.rest.webservices.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {
	
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank(message = "User should not be blank")
	private String userName;
	
	
	private int age;
	
	@Size(min = 2, message ="Country should be in short form in two character")
	private String country;
	
	@OneToMany
	@JsonIgnore
	private List<User> users;
	
	protected User() {
		
	}
	
	public User(int id,String userName, int age, String country) {
		super();
		this.id =id;
		this.userName = userName;
		this.age = age;
		this.country = country;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", age=" + age + ", country=" + country + "]";
	}
	
	

	
	
	

}
