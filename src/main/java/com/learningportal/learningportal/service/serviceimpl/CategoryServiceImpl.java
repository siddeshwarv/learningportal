package com.learningportal.learningportal.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningportal.learningportal.model.Category;
import com.learningportal.learningportal.model.Course;
import com.learningportal.learningportal.repository.CategoryRepository;
import com.learningportal.learningportal.repository.CourseRepository;
import com.learningportal.learningportal.repository.UserRepository;
import com.learningportal.learningportal.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		List<Course> courses = category.getCourses();
		for(int i=0;i<courses.size();i++) {
			courseRepository.save(courses.get(i));
		}
		categoryRepository.save(category);
		return category;
	}

	@Override
	public Category getCategoryById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			return category;
		}
		return null;
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public List<Course> getAllCourses(Integer id) {
		// TODO Auto-generated method stub
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			return category.getCourses();
		}
		return null;
	}

	@Override
	public Category deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			categoryRepository.deleteById(id);
			return category;
		}
		return null;
	}

	@Override
	public Category addCourseToCategory(Course course, Integer categoryId) {
		// TODO Auto-generated method stub
		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
		if(optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			List<Course> courses = category.getCourses();
			courses.add(course);
			return category;
		}
		return null;
	}

}
