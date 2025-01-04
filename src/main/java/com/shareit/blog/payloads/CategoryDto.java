package com.shareit.blog.payloads;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer catergoryId;
	
	@NotEmpty
	@Size(min = 4, message = "min charater for categoryTitle is 4")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min = 10, message = "min charater for categoryDescription is 10")	
	private String categoryDescription;
}
