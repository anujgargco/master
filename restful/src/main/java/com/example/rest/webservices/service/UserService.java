package com.example.rest.webservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.example.rest.webservices.bean.User;

@Component
public class UserService {
	
	private static List<User> users= new ArrayList<>();
	private static int userCount =0;
	
	static{
		users.add(new User(++userCount,"Vihas",10,"US"));
		users.add(new User(++userCount,"Prisha",9,"US"));
		users.add(new User(++userCount,"Rohit",11,"US"));
	}

	public List<User> findAll(){
		return users;
	}

	public User findOne(int id) {
		//Predicate<User> predicaate = user-> user.getId()==id;
		return users.stream().filter(u->u.getId()==id).findFirst().orElse(null);
	}

	public User save(User user) {
		user.setId(++userCount);
		users.add(user);	
		return findOne(user.getId());
	}

	public void delete(int id) {
		Predicate<User> predicate = user-> user.getId()==id;
		users.removeIf(predicate);
		// TODO Auto-generated method stub
		
	}

}
