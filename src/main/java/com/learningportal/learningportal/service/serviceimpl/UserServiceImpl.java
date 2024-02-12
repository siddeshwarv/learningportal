package com.learningportal.learningportal.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningportal.learningportal.model.Course;
import com.learningportal.learningportal.model.User;
import com.learningportal.learningportal.repository.CategoryRepository;
import com.learningportal.learningportal.repository.CourseRepository;
import com.learningportal.learningportal.repository.UserRepository;
import com.learningportal.learningportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<User> getUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public List<Course> getFavouriteCourses(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User user1 = user.get();
			return user1.getFavouriteCourses();
			
		}
		return null;
		}

	@Override
	public List<Course> getSubscribedCourses(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User user1 = user.get();
			return user1.getSubscribedCourses();
			
		}
		return null;
		}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		List<Course> favouriteCourses = user.getFavouriteCourses();
		for(int i=0;i<favouriteCourses.size();i++) {
			courseRepository.save(favouriteCourses.get(i));
		}
		List<Course> subscribedCourses = user.getFavouriteCourses();
		for(int i=0;i<subscribedCourses.size();i++) {
			courseRepository.save(subscribedCourses.get(i));
		}
		userRepository.save(user);
		return user;
	}

	@Override
	public User deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			userRepository.deleteById(userId);
			return user.get();	
		}
		return null;
	}

	@Override
	public List<Course> addFavouriteCourses(Integer id, Course course) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			User user1 = user.get();
			List<Course> courses= user1.getFavouriteCourses();
			courses.add(course);
			user1.setFavouriteCourses(courses);
			return courses;	
		}
	
		return null;
	}

	@Override
	public List<Course> addSubscribedCourses(Integer id, Course course) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			User user1 = user.get();
			List<Course> courses= user1.getSubscribedCourses();
			courses.add(course);
			user1.setSubscribedCourses(courses);
			return courses;	
		}
		return null;
	}
}