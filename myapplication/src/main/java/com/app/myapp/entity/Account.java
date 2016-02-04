package com.app.myapp.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account implements Serializable
{
	private static final long serialVersionUID = 2043966252976257485L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable=true,nullable=false,unique=true)
	Long id;
	@Column(name="ACCOUNT_TYPE")
	String accountType;
	@Column(name="ACCESS_TYPE")
	String accessType;
	@Column(name="USER_NAME")
	String username;
	@Column(name="STATUS")
	String status;
	Timestamp validity;
	Timestamp created;
	@OneToMany(mappedBy="account", fetch=FetchType.LAZY)
    private Set<User> users;
	public Long getId() {
		return id;
	}
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getValidity() {
		return validity;
	}
	public void setValidity(Timestamp validity) {
		this.validity = validity;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
