package com.shareit.blog.repositeries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shareit.blog.entities.Category;
import com.shareit.blog.entities.Post;
import com.shareit.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	
	List<Post> findByUser(User U);
	List<Post> findByCategory(Category C);
//	List<Post> findByTitleContaining(String Keyword);
	
	@Query(value = "select * from posts where Post_title like :key", nativeQuery = true)
	List<Post> searchTitleContaining(@Param(value = "key") String keyword);
}
