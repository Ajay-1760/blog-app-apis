package com.shareit.blog.services;

import java.util.List;

import com.shareit.blog.payloads.UserDto;

import jakarta.validation.Valid;

public interface UserService {

	UserDto CreateUser(UserDto user);

	UserDto updateUser(UserDto user, Integer id);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);

	UserDto registerNewUser(@Valid UserDto userDto);

}
