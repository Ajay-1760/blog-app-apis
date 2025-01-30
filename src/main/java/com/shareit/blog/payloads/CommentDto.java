package com.shareit.blog.payloads;

import com.shareit.blog.entities.Post;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CommentDto {
	
	private Integer id;
	
	private String content;
}
