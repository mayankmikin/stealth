package com.app.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.myapp.entity.Role;
import com.app.myapp.repository.RoleRepository;

@Service("roleService")
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService 
{
	@Autowired
	private RoleRepository repository;
	
	@Override
	@Transactional
	public Role save(Role entity) {
		return repository.save(entity);
	}

	@Override
	public Role findOne(Long primaryKey) {
		return repository.findOne(primaryKey);
	}

	@Override
	public Role findOne(Specification<Role> specification) {
		return repository.findOne(specification);
	}

	@Override
	public List<Role> findAll(Specification<Role> specification) {
		return repository.findAll(specification);
	}

	@Override
	public Page<Role> findAll(Specification<Role> specification,
			Pageable pageable) {
		return repository.findAll(specification, pageable);
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		return repository.findAll(pageable);
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

	@Override
	public List<Role> findAll() {
		return repository.findAll();
	}

}
