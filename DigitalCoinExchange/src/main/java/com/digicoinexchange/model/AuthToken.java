package com.digicoinexchange.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AuthToken {	
	@Id
    private String token;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

    public AuthToken(){

    }

	public AuthToken(String token) {
		super();
		this.token = token;
		this.user = user;
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
