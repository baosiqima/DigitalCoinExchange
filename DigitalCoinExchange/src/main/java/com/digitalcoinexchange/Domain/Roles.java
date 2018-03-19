package com.digitalcoinexchange.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity
public class Roles {
	
	@Id
	String role_id;
	String role;
	
	
	@ManyToOne
	 User user;
	
	public String getId() {
		return role_id;
	}
	public void setId(String role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Roles(String role_id, String role) {
		super();
		this.role_id = role_id;
		this.role = role;
	}

	
	public Roles()
	{
		
	}
	
	

	
	
}
