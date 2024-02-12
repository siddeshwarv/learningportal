package com.learningportal.learningportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningportal.learningportal.model.User;
import com.learningportal.learningportal.service.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServiceImpl userSeviceImpl;
	
	@PostMapping()
	public User saveUser(@RequestBody User user) {
		return userSeviceImpl.addUser(user);
	}
	@GetMapping()
	public List<User> getAllUsers(){
		return userSeviceImpl.getUsers();
	}
	@DeleteMapping("/{userId}")
	public User deleteUser(@PathVariable Integer userId) {
		return userSeviceImpl.deleteUser(userId);
	}
}
