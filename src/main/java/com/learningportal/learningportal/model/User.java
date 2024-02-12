package com.learningportal.learningportal.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String userName;
//	@Enumerated(EnumType.STRING)
	private UserRole userType;
	@ManyToMany(fetch = FetchType.LAZY,cascade =  {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable( name="favourite_courses",joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="courseId"))
	private List<Course> favouriteCourses;
	@ManyToMany(fetch = FetchType.LAZY,cascade =  {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable( name="subscribed_courses",joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="courseId"))
	private List<Course> subscribedCourses;
//	@ManyToMany(fetch = FetchType.LAZY,cascade =  {CascadeType.ALL})
//	@JoinTable( name="created_courses",joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="courseId"))
//	private List<Course> createdCourses;
	
}
