package com.learningportal.learningportal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.learningportal.learningportal.dto.UserDTO;
import com.learningportal.learningportal.model.User;

@Mapper(componentModel="spring")
public interface UserMapper {
	
		@Mappings({
		@Mapping(source = "userId", target = "userId"),
        @Mapping(source = "userName", target = "userName"),
        @Mapping(source = "userType", target = "userType"),
        @Mapping(source = "favouriteCourses", target = "favouriteCourses"),
        @Mapping(source = "subscribedCourses", target = "subscribedCourses")
		})
		UserDTO userToUserDTO(User user);

		@Mappings({
        @Mapping(source = "userId", target = "userId"),
        @Mapping(source = "userName", target = "userName"),
        @Mapping(source = "userType", target = "userType"),
        @Mapping(source = "favouriteCourses", target = "favouriteCourses"),
        @Mapping(source = "subscribedCourses", target = "subscribedCourses")
		})
		User userDTOToUser(UserDTO userDTO);
}
	

