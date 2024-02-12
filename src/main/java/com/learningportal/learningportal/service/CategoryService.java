package com.learningportal.learningportal.service;

import java.util.List;

import com.learningportal.learningportal.model.Category;
import com.learningportal.learningportal.model.Course;

public interface CategoryService {
	Category createCategory(Category category);
	Category getCategoryById(Integer id);
	List<Category> getAllCategory();
	List<Course> getAllCourses(Integer id);
	Category deleteCategory(Integer id);
	Category addCourseToCategory(Course course,Integer categoryId);
}
