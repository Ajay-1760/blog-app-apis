package com.shareit.blog.services;

import java.util.List;

import com.shareit.blog.entities.Post;
import com.shareit.blog.payloads.PostDto;
import com.shareit.blog.payloads.PostResponse;

public interface PostService {

	//Create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//getAllPost
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	//get single post
	PostDto getPostById(Integer postId);
	
	//getAll post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//getAll post by user
	List<PostDto> getPostByUser(Integer userId);
	
	
	//search post
	List<PostDto> searchPosts(String keyword);
}
