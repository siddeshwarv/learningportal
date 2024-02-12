package com.learningportal.learningportal.service;

import java.util.List;

import com.learningportal.learningportal.dto.CourseDTO;
import com.learningportal.learningportal.model.Course;

public interface CourseService {
	List<Course>getCourses();
	CourseDTO getCourseById(Integer id);
	Course addCourse(Course course);
	Course delteCourse(Integer courseID);
	Course updateCourse(Course course);
}
