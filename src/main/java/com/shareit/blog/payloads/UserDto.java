package com.shareit.blog.payloads;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "Username must be of 4 characters")
	private String name;
	
	@Email (message = "Email address is not valid !")
	private String email;
	
	@NotEmpty
	private String about;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be minimum of 3 chars and max of 10 char")
	private String password;
	
	
}
