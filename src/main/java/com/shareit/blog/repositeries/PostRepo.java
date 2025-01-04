package com.shareit.blog.repositeries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shareit.blog.entities.Category;
import com.shareit.blog.entities.Post;
import com.shareit.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	
	List<Post> findByUser(User U);
	List<Post> findByCategory(Category C);
}
