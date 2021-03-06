package com.machao.sjcnh.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.machao.sjcnh.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByName(String name);

	List<User> findAllByOrderByName();
	
	Page<User> findAllByOrderByName(Pageable pageable);
}