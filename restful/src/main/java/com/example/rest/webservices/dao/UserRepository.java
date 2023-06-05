package com.example.rest.webservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.webservices.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
