package com.learningportal.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningportal.learningportal.model.Course;

public interface CourseRepository extends JpaRepository<Course,Integer> {
	
}
