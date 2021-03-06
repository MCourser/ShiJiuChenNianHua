package com.machao.sjcnh.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.machao.sjcnh.exception.ResourceNotFoundException;
import com.machao.sjcnh.model.Permission;
import com.machao.sjcnh.model.Role;
import com.machao.sjcnh.model.form.RoleCreateForm;
import com.machao.sjcnh.model.form.RoleUpdateForm;
import com.machao.sjcnh.service.PermissionService;
import com.machao.sjcnh.service.RoleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RestControllerAdvice 
@RequestMapping("/role")
public class RoleController extends BaseController{

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService;
	
	
	@ApiOperation(value = "List Roles", notes = "list system roles")
	@PreAuthorize("authenticated and hasPermission('/role/', 'role:list')")
	@GetMapping("/")
	public ResponseEntity<List<Role>> list() {
		return ResponseEntity.ok(roleService.list());
	}
	
	@ApiOperation(value = "Load Role", notes = "load a role by id")
	@PreAuthorize("authenticated and hasPermission('/role/{id}', 'role:load')")
	@GetMapping("/{id}")
	public ResponseEntity<Role> load(@PathVariable int id) {
		return ResponseEntity.ok(roleService.selectByPrimaryKey(id));
	}
	
	@ApiOperation(value = "Add Role", notes = "add role")
	@PreAuthorize("authenticated and hasPermission('/role/', 'role:add')")
	@PostMapping("/")
	public ResponseEntity<Role> create(@Valid @RequestBody RoleCreateForm roleCreateForm, Errors errors) {
		super.checkRequestParams(errors);
		
		Role role = new Role();
		role.setName(roleCreateForm.getName());
		role.setDescription(roleCreateForm.getDescription());
		Set<Permission> permissionList = new HashSet<Permission>();
		roleCreateForm.getPermissions().forEach(permissionId->{
			Permission permission = permissionService.selectByPrimaryKey(permissionId);
			if(permission == null) throw new ResourceNotFoundException();
			permissionList.add(permission);
		});
		role.setPermissions(permissionList);
		
		Role savedRole = roleService.insert(role);
		
		return ResponseEntity.ok(savedRole);
	}
	
	@ApiOperation(value = "Update Role", notes = "update role")
	@PreAuthorize("authenticated and hasPermission('/role/', 'role:update')")
	@PutMapping("/")
	public ResponseEntity<Role> update(@Valid @RequestBody RoleUpdateForm roleUpdateForm, Errors errors) {
		super.checkRequestParams(errors);
		
		Role role = roleService.selectByPrimaryKey(roleUpdateForm.getId());
		if(role == null) throw new ResourceNotFoundException();
		
		role.setName(roleUpdateForm.getName());
		role.setDescription(roleUpdateForm.getDescription());
		Set<Permission> permissionList = new HashSet<Permission>();
		roleUpdateForm.getPermissions().forEach(permissionId->{
			Permission permission = permissionService.selectByPrimaryKey(permissionId);
			if(permission == null) throw new ResourceNotFoundException();
			permissionList.add(permission);
		});
		role.setPermissions(permissionList);
		
		Role savedRole = roleService.update(role);
		
		return ResponseEntity.ok(savedRole);
	}
	
	@ApiOperation(value = "Delete Role", notes = "delete role")
	@PreAuthorize("authenticated and hasPermission('/role/{id}', 'role:delete')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Role> delete(@PathVariable int id) {
		Role role = roleService.selectByPrimaryKey(id);
		if(role == null) throw new ResourceNotFoundException();
		
		roleService.deleteByPrimaryKey(id);
		
		return ResponseEntity.ok(role);
	}
}
