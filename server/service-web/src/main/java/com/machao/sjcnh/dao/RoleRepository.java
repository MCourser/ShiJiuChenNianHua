package com.machao.sjcnh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.machao.sjcnh.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
}