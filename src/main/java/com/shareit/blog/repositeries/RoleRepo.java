package com.shareit.blog.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shareit.blog.entities.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
