package com.shareit.blog.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shareit.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
