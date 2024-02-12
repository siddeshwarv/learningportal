package com.learningportal.learningportal.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.learningportal.learningportal.dto.CourseDTO;
import com.learningportal.learningportal.model.Course;

public interface CourseMapper {
		@Mappings({
        @Mapping(source = "courseId", target = "courseId"),
        @Mapping(source = "courseName", target = "courseName"),
        @Mapping(source = "author", target = "author")
		})
		CourseDTO courseToCourseDTO(Course course);
		
		@Mappings({
        @Mapping(source = "courseId", target = "courseId"),
        @Mapping(source = "courseName", target = "courseName"),
        @Mapping(source = "author", target = "author")
		})
		Course courseDTOToCourse(CourseDTO courseDTO);
}
