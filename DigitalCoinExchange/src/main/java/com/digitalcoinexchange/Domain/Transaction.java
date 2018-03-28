package com.digitalcoinexchange.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transId;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User userId;

	public Transaction(){

	}

	public Transaction(int transId, User userId) {
		super();
		this.transId = transId;
		this.userId = userId;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUser(User userId) {
		this.userId = userId;
	}

}
