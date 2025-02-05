package com.shareit.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shareit.blog.config.AppConstants;
import com.shareit.blog.payloads.ApiResponse;
import com.shareit.blog.payloads.PostDto;
import com.shareit.blog.payloads.PostResponse;
import com.shareit.blog.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	//create
	@PostMapping("/user/{userId}/category/{categoryId}")
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto post, 
												@PathVariable Integer userId, 
												@PathVariable Integer categoryId){		
		
		PostDto createdPost=postService.createPost(post, userId, categoryId);
		
		return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
	}
	
	//get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		
		List<PostDto> posts=this.postService.getPostByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
		
	}
	
	//get by category
	@GetMapping("/category/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer userId){
		
		List<PostDto> posts=this.postService.getPostsByCategory(userId);
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
		
	}
	
	//get All Posts
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir
			){
		
		PostResponse postResponse= this.postService.getAllPost( pageNumber, pageSize, sortBy, sortDir);
		
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);

	}
	
	//get All Posts
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		
		PostDto post = this.postService.getPostById(postId);
		
		return new ResponseEntity<PostDto>(post, HttpStatus.OK);
	}
	
	//delete post by id
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<?> deletePostById(@PathVariable Integer postId){
		postService.deletePost(postId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("post Deleted Successfully !", true),HttpStatus.OK);
	}
	
	//update post by id
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto post, @PathVariable Integer postId){
		
		PostDto postDto = this.postService.updatePost(post, postId);
		
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}
	
	//searchPost
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPost(@PathVariable String keyword){
		
		List<PostDto> posts=this.postService.searchPosts(keyword);
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);		
	}
	
}
