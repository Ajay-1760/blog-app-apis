package com.shareit.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shareit.blog.entities.Comment;
import com.shareit.blog.entities.Post;
import com.shareit.blog.exceptions.ResourceNotFoundException;
import com.shareit.blog.payloads.CommentDto;
import com.shareit.blog.repositeries.CommentRepo;
import com.shareit.blog.repositeries.PostRepo;
import com.shareit.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post ", "postId", postId));
		
		Comment comment=this.modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
		
		Comment savedComment = this.commentRepo.save(comment);
		
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment comment =this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment ", "commentId", commentId));
		
		this.commentRepo.delete(comment);
	}
	


}
