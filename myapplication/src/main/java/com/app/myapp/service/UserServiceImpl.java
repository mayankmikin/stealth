package com.app.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.myapp.entity.User;
import com.app.myapp.repository.UserRepository;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserRepository repository;
	
	
	@Override
	@Transactional
	public User save(User entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public User findOne(Long primaryKey) {
		// TODO Auto-generated method stub
		return repository.findOne(primaryKey);
	}

	@Override
	public User findOne(Specification<User> specification) {
		// TODO Auto-generated method stub
		return repository.findOne(specification);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<User> findAll(Specification<User> specification) {
		// TODO Auto-generated method stub
		return repository.findAll(specification);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}

	@Override
	public Page<User> findAll(Specification<User> specification,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(specification, pageable);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return repository.count();
	}

	@Override
	@Transactional
	public void delete(Long primaryKey) {
		repository.delete(primaryKey);

	}

}
