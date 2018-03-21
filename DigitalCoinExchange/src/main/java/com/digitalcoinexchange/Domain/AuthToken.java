package com.digitalcoinexchange.Domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="authtoken")


public class AuthToken {
	
	
	@Id
	String authId;
	String token;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	

	
	public AuthToken(String id, String token) {
		
		super();
		System.out.println("chek1"+id+"---"+token);
		this.authId = id;
		this.token = token;
		
	}

	public AuthToken()
	{
		
	}
	
	public String getId() {
		return authId;
	}
	public void setId(String id) {
		this.authId = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public User getUser()
	{
		return user;
		
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
