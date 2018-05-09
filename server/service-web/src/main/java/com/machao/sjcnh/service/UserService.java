package com.machao.sjcnh.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.machao.sjcnh.model.User;

@Transactional(isolation=Isolation.READ_COMMITTED)
public interface UserService extends BasePageableService<User, Integer> {
	
	User selectByName(String name);
	
	boolean hasPermission(User user, Object resource, Object permission);
	
	boolean hasPermission(Integer id, Object resource, Object permission);
}
