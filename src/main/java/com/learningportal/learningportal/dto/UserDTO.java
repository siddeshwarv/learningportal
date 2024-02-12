package com.learningportal.learningportal.dto;

import java.util.List;

import com.learningportal.learningportal.model.Course;
import com.learningportal.learningportal.model.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
public class UserDTO {
	private Integer userId;
	private String userName;
	private UserRole userType;
	private List<Course> favouriteCourses;
	private List<Course> subscribedCourses;
}
