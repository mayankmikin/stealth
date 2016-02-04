/**
 * 
 */
package com.app.myapp.service;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Mayank Verma
 *
 */
public interface XACoreService<T, PK extends Serializable> {
	/*
	 * Save or Update the passed model
	 */
	T save(T entity);

	/*
	 * Read from Repository the model
	 */
	T findOne(PK primaryKey);
	T findOne(Specification<T> specification);

	/*
	 * Read from Repository all model
	 */
	List<T> findAll();
	List<T> findAll(Specification<T> specification);
	Page<T> findAll(Pageable pageable);
	Page<T> findAll(Specification<T> specification, Pageable pageable);

	/*
	 * Read from Repository all model count
	 */
	Long count();

	/*
	 * Delete from Repository the model
	 */
	void delete(PK primaryKey);	

}
