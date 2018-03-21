package com.digitalcoinexchange.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int roleId;
	
	private Role role;
	
	public Roles()
	{
		
	}

	public Roles(int roleId, Role role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

	
	
}
