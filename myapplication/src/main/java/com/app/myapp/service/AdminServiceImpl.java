package com.app.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.myapp.entity.Admin;
import com.app.myapp.repository.AdminRepository;
@Service("adminService")
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository repository;
	@Override
	@Transactional
	public Admin save(Admin entity) {
		
		return repository.save(entity);
	}

	@Override
	public Admin findOne(Long primaryKey) {
		return repository.findOne(primaryKey);
	}

	@Override
	public Admin findOne(Specification<Admin> specification) {
		return repository.findOne(specification);
	}

	@Override
	public List<Admin> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Admin> findAll(Specification<Admin> specification) {
		return repository.findAll(specification);
	}

	@Override
	public Page<Admin> findAll(Pageable pageable) {
		
		return repository.findAll(pageable);
	}

	@Override
	public Page<Admin> findAll(Specification<Admin> specification,
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
