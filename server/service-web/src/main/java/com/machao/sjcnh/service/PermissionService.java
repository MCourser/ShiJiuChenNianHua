package com.machao.sjcnh.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.machao.sjcnh.model.Permission;

@Transactional(isolation=Isolation.READ_COMMITTED)
public interface PermissionService extends BaseService<Permission, Integer>{

}
