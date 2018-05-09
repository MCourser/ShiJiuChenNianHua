package com.machao.sjcnh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.machao.sjcnh.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
	
}