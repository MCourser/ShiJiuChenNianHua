package com.machao.sjcnh.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machao.sjcnh.dao.PermissionRepository;
import com.machao.sjcnh.model.Permission;
import com.machao.sjcnh.service.PermissionService;

@Service
public class PermissionServiceImp implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public Permission insert(Permission record) {
		return this.permissionRepository.save(record);
	}

	@Override
	public void deleteByPrimaryKey(Integer id) {
		this.permissionRepository.delete(id);
	}

	@Override
	public Permission update(Permission record) {
		return this.permissionRepository.save(record);
	}

	@Override
	public Permission selectByPrimaryKey(Integer id) {
		return permissionRepository.findOne(id);
	}

	@Override
	public List<Permission> list() {
		return permissionRepository.findAll();
	}

}
