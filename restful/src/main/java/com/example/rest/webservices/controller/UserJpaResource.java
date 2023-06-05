package com.example.rest.webservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.webservices.bean.User;
import com.example.rest.webservices.dao.UserRepository;
import com.example.rest.webservices.exception.UserNotFoundException;
import com.example.rest.webservices.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	@Autowired
	private UserService userService;
	
	private MessageSource messageSource;
	
	@Autowired
	private UserRepository repository;
	
	public UserJpaResource(MessageSource messageSource) {
		this.messageSource =messageSource;
	}
	@GetMapping("/jpa/user")
	public String getUserInfo() {
		return "HELLO WORLD";
	}
	
	@GetMapping("/jpa/user-international")
	public String getUserInternationl() {
		Locale locale =LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning", null, "Default Message", locale);
		
	}
	
	@GetMapping("/jpa/userInfo")
	public List<User> getAllUserDetails() {
		return repository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> getUserDetail(@PathVariable int id) {
		Optional<User> user =repository.findById(id);
		if(user ==null) {
			throw new UserNotFoundException("User doesn't exits for Id:"+id);
		}
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUserDetails());
		entityModel.add(link.withRel("all-users"));
		return entityModel ;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User saveUser =repository.save(user);
		URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location ).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteById(@PathVariable int id) {
		userService.delete(id);
	}

}
