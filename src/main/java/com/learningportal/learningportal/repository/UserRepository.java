package com.learningportal.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningportal.learningportal.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
