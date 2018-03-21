package com.digitalcoinexchange.Domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int userId;
	String username;
	String phone;
	String country;
	String password;
	boolean enabled;
	String email;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(	name = "user_roles",
            	joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"),
            	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"))
    private List<Roles> roles;
	
	public User()
	{
		
	}

	public User(int userId, String username, String phone, String country, String password, boolean enabled,
			String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.phone = phone;
		this.country = country;
		this.password = password;
		this.enabled = enabled;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}