package com.shareit.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shareit.blog.payloads.CategoryDto;

public interface CategoryService {
	
	//Create
	public CategoryDto createCategory(CategoryDto categoryDto);

	//update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	public void deleteCategory(Integer categoryId);
	
	//get
	CategoryDto getCategory(Integer categoryId);
	
	//getAll
	List<CategoryDto> getCategories();

}
