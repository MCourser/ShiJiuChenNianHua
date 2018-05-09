package com.machao.sjcnh.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.machao.sjcnh.model.Role;

@Transactional(isolation=Isolation.READ_COMMITTED)
public interface RoleService extends BaseService<Role, Integer>{

}
