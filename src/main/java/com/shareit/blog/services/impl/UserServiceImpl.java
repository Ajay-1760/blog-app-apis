package com.shareit.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shareit.blog.config.AppConstants;
import com.shareit.blog.entities.Role;
import com.shareit.blog.entities.User;
import com.shareit.blog.exceptions.ResourceNotFoundException;
import com.shareit.blog.payloads.UserDto;
import com.shareit.blog.repositeries.RoleRepo;
import com.shareit.blog.repositeries.UserRepo;
import com.shareit.blog.services.UserService;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepo userRepo;
	
	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public UserDto CreateUser(UserDto userDto) {

		User user = this.dtoToUser(userDto);

		User savedUser = this.userRepo.save(user);

		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow((()->new ResourceNotFoundException("User","id",(long)userId)));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow((()->new ResourceNotFoundException("User","id",(long)userId)));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users=this.userRepo.findAll();
		
		List<UserDto> userDtos= users.stream().map(u->this.userToDto(u)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {

		User user=this.userRepo.findById(userId).orElseThrow((()->new ResourceNotFoundException("User","id",(long)userId)));
		
		this.userRepo.delete(user);
	}

	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());

		return user;

	};

	public UserDto userToDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);

//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());

		return userDto;
	}

	@Override
	public UserDto registerNewUser(@Valid UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);

		// encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		// roles
		Role role = this.roleRepo.findById(AppConstants.ROLE_USER).get();

		user.getRoles().add(role);

		User newUser = this.userRepo.save(user);

		return this.modelMapper.map(newUser, UserDto.class);
	}

}
