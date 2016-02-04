package com.app.myapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin implements Serializable
{

	/**
	 * @author Mayank Verma
	 */
	private static final long serialVersionUID = -7754270622558975724L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable=true,nullable=false,unique=true)
	Long id;
	private String key;
	private String adminname;
	
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
