package com.shareit.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Comments;

import io.micrometer.common.lang.NonNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private Integer postId;
	
	@NonNull
	private String title;
	
	@NonNull
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;	
	
	private Set<CommentDto> comments=new HashSet<>();
	
}
