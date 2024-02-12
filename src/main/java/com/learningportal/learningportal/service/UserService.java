package com.learningportal.learningportal.service;

import java.util.List;

import com.learningportal.learningportal.model.Course;
import com.learningportal.learningportal.model.User;

public interface UserService {
	List<User> getUsers();
	List<Course> getFavouriteCourses(Integer userId);
	List<Course> getSubscribedCourses(Integer userId);
	User addUser(User user);
	User deleteUser(Integer userId);
	List<Course> addFavouriteCourses(Integer id, Course course);
	List<Course> addSubscribedCourses(Integer id, Course course);
	
}
