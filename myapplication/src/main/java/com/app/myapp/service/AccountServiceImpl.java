package com.app.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.myapp.entity.Account;
import com.app.myapp.entity.Account;
import com.app.myapp.repository.AccountRepository;
import com.app.myapp.repository.AccountRepository;

@Service("accountService")
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService 
{
	@Autowired
	private AccountRepository repository;
	
	
	@Override
	@Transactional
	public Account save(Account entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public Account findOne(Long primaryKey) {
		// TODO Auto-generated method stub
		return repository.findOne(primaryKey);
	}

	@Override
	public Account findOne(Specification<Account> specification) {
		// TODO Auto-generated method stub
		return repository.findOne(specification);
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Account> findAll(Specification<Account> specification) {
		// TODO Auto-generated method stub
		return repository.findAll(specification);
	}

	@Override
	public Page<Account> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}

	@Override
	public Page<Account> findAll(Specification<Account> specification,
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
