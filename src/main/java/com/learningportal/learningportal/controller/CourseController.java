package com.learningportal.learningportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningportal.learningportal.dto.CourseDTO;
import com.learningportal.learningportal.model.Course;
import com.learningportal.learningportal.service.serviceimpl.CourseServiceImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseServiceImpl courseServiceImpl;
	
	@PostMapping()
	public Course saveCourse(@RequestBody Course course) {
		log.info("This is input:"+course.getCourseId()+","+course.getCourseName()+",");
		return courseServiceImpl.addCourse(course);
		}
	@GetMapping()
	public List<Course> getAllCourse(){
		return courseServiceImpl.getCourses();
	}
	@DeleteMapping("/{courseId}")
	public Course deleteUser(@PathVariable Integer courseId) {
		return courseServiceImpl.delteCourse(courseId);
	}
	@GetMapping("/{courseId}")
	public CourseDTO getCourse(@PathVariable Integer courseId) {
		return courseServiceImpl.getCourseById(courseId);
	}
	@PutMapping() 
	public Course updateCourse(@RequestBody Course course) {
		return courseServiceImpl.updateCourse(course);
	}
	
}
