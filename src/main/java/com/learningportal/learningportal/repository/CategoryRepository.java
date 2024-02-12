package com.learningportal.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningportal.learningportal.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
