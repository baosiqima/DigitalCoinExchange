package com.digitalcoinexchange.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="authtoken")
public class AuthToken {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authId;
	private String token;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public AuthToken(){

	}
	public AuthToken( String token) {
		super();
		//this.authId = authId;
		this.token = token;
		//this.user = user;
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
