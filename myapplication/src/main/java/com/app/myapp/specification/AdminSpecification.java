package com.app.myapp.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.app.myapp.entity.Admin;

public class AdminSpecification 
{
	 public static Specification<Admin> fetchbyKey(final String key) {
	        return new Specification<Admin>() {
	            @Override
	            public Predicate toPredicate(Root<Admin> root, CriteriaQuery<?> query, CriteriaBuilder builder) 
	            {
	                List<Predicate> predicateList = new ArrayList<Predicate>();
	                if( (key != null ) && !(key.isEmpty()) ) 
	                {
	                    
	                	Predicate p = builder.equal(root.get("key"), key);
	                    predicateList.add(p);
	                }
	                Predicate[] predicates = new Predicate[predicateList.size()];
	                predicateList.toArray(predicates);
	                return builder.and(predicates);
	            }
	        };
	 }
}
