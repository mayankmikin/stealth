package com.app.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.app.myapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User> {

}
