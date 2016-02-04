package com.app.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.app.myapp.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>,JpaSpecificationExecutor<Admin> {

}
