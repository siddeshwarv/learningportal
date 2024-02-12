package com.learningportal.learningportal.dto;

import java.util.List;

import com.learningportal.learningportal.model.Course;

import lombok.Data;


@Data
public class CategoryDTO {

	private Integer id;
	private String name;
	private List<Course> courses; 
}
