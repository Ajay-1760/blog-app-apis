package com.shareit.blog.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shareit.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

	
}
