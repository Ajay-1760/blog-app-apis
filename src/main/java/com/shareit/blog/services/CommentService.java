package com.shareit.blog.services;

import org.springframework.stereotype.Service;

import com.shareit.blog.payloads.CommentDto;


public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer commentId);
}
