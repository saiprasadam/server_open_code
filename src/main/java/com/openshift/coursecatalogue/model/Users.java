package com.openshift.coursecatalogue.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author kaleembasha.akbar
 *
 * Model class for User Document
 */
@Document
public class Users {
	
	@Id
	private String id;
	
	private String name;
	
	private String password;
	
	private boolean admin_access;
	
	private String role;
	
	private String email;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin_access() {
		return admin_access;
	}

	public void setAdmin_access(boolean admin_access) {
		this.admin_access = admin_access;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", password=" + password + ", admin_access=" + admin_access
				+ ", role=" + role + ", email=" + email + "]";
	}
	
	

}
