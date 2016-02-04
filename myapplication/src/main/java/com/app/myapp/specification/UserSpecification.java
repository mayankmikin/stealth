package com.app.myapp.specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.app.myapp.entity.User;


public class UserSpecification 
{
	  public static Specification<User> fetchAll(final String email) {
	        return new Specification<User>() {
	            @Override
	            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) 
	            {
	                List<Predicate> predicateList = new ArrayList<Predicate>();
	                if( (email != null ) && !(email.isEmpty()) ) 
	                {
	                    
	                	Predicate p = builder.equal(root.get("emailid"), email);
	                    predicateList.add(p);
	                }
	                Predicate[] predicates = new Predicate[predicateList.size()];
	                predicateList.toArray(predicates);
	                return builder.and(predicates);
	            }
	        };
	    }
	  public static Specification<User> checkPhonenumber(final String phonenumber) {
	        return new Specification<User>() 
	        {
	            @Override
	            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) 
	            {
	                List<Predicate> predicateList = new ArrayList<Predicate>();
	                if( (phonenumber != null ) && !(phonenumber.isEmpty()) ) 
	                {
	                    
	                	Predicate p = builder.equal(root.get("phonenumber"), phonenumber);
	                    predicateList.add(p);
	                }
	                Predicate[] predicates = new Predicate[predicateList.size()];
	                predicateList.toArray(predicates);
	                return builder.and(predicates);
	            }
	        };
	    }
	  
	  public static Specification<User> checkEmail(final String email) 
	  {
	        return new Specification<User>() 
	        {
	            @Override
	            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) 
	            {
	                List<Predicate> predicateList = new ArrayList<Predicate>();
	                if( (email != null ) && !(email.isEmpty()) ) 
	                {
	                    
	                	Predicate p = builder.equal(root.get("emailid"), email);
	                    predicateList.add(p);
	                }
	                Predicate[] predicates = new Predicate[predicateList.size()];
	                predicateList.toArray(predicates);
	                return builder.and(predicates);
	            }
	        };
	    }

}
