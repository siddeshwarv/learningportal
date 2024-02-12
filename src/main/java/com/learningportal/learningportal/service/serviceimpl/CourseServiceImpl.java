package com.learningportal.learningportal.service.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningportal.learningportal.dto.CourseDTO;
import com.learningportal.learningportal.mapper.CourseMapper;
import com.learningportal.learningportal.model.Course;
import com.learningportal.learningportal.repository.CourseRepository;
import com.learningportal.learningportal.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	private CourseMapper courseMapper;
	@Override
	public List<Course> getCourses() {
		
		return courseRepository.findAll();
	}

	@Override
	public CourseDTO getCourseById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Course> course = courseRepository.findById(id);
		if(course.isPresent()) {
			return courseMapper.courseToCourseDTO(course.get());
		}
		return null;
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		log.info("Service, This is input:"+course.getCourseId()+","+course.getCourseName()+","+course.getAuthor());
		return courseRepository.save(course);
	}

	@Override
	public Course delteCourse(Integer courseId) {
		// TODO Auto-generated method stub
		Optional<Course> optionalCourse = courseRepository.findById(courseId);
		if(optionalCourse.isPresent()) {
			Course course = optionalCourse.get();
			courseRepository.deleteById(courseId);
			return course;
		}
		return null;
		
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);
		return course;
	}

}
