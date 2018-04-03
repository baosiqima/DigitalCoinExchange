package com.digicoinexchange.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="otp")
public class Otp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authId;
	private String token;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public Otp(){

	}
	public Otp( String token) {
		super();	
		this.token = token;		
	}
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	




}
