package com.learningportal.learningportal.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.learningportal.learningportal.dto.CategoryDTO;
import com.learningportal.learningportal.model.Category;

public interface CategoryMapper {
		@Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "courses", target = "courses")
		})
		CategoryDTO categoryToCategoryDTO(Category category);

		@Mappings({	
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "courses", target = "courses")
		})
		Category categoryDTOToCategory(CategoryDTO categoryDTO);
}
