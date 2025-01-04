package com.shareit.blog.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shareit.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	
}
