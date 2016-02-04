package com.app.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.myapp.entity.Permission;
import com.app.myapp.repository.PermissionRepository;

@Service("permissionService")
@Transactional(readOnly = true)
public class PermissionServiceImpl implements PermissionService 
{
	@Autowired
	PermissionRepository repository;
	@Override
	@Transactional
	public Permission save(Permission entity) {
		return repository.save(entity);
	}

	@Override
	public Permission findOne(Long primaryKey) {
		return repository.findOne(primaryKey);
	}

	@Override
	public Permission findOne(Specification<Permission> specification) {
		return repository.findOne(specification);
	}

	@Override
	public List<Permission> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Permission> findAll(Specification<Permission> specification) {
		return repository.findAll(specification);
	}

	@Override
	public Page<Permission> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Page<Permission> findAll(Specification<Permission> specification,
			Pageable pageable) {
		return repository.findAll(specification, pageable);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	@Transactional
	public void delete(Long primaryKey) {
		repository.delete(primaryKey);

	}

}
