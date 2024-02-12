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

import com.learningportal.learningportal.model.Category;
import com.learningportal.learningportal.model.Course;
import com.learningportal.learningportal.service.serviceimpl.CategoryServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@PostMapping()
	public Category addCategory(@RequestBody Category category) {
		return categoryServiceImpl.createCategory(category);
	}
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable Integer categoryId) {
		return categoryServiceImpl.getCategoryById(categoryId );
	}
	@GetMapping()
	public List<Category> getCategory(){
		return categoryServiceImpl.getAllCategory();
	}
//	@GetMapping("/{categoryId}")
//	public List<Course> getCourses(@PathVariable Integer categoryId){
//		return categoryServiceImpl.getAllCourses(categoryId);
//	}
	@DeleteMapping("/{categoryId}")
	public Category deleteCategory(@PathVariable Integer categoryId) {
		return categoryServiceImpl.deleteCategory(categoryId);
	}
}
