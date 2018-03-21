package com.digitalcoinexchange.Domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Currency {
	
	@Id
	int id;
	long currency;
	

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "walletId")
    private Wallet wallet;
//
//	@OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId")
//    private User user;
	
	public Currency()
	{
		
	}

	public Currency(int id, long currency, Wallet wallet,int walletId) {
		super();
		this.id = id;
		this.currency = currency;
		//this.wallet = wallet;
		//this.wallet=new Wallet(walletId,"","",1);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCurrency() {
		return currency;
	}

	public void setCurrency(long currency) {
		this.currency = currency;
	}

	
	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	/*
	public User getUser()
	{
		return user;		
	}
	
	public void setUser(User user)
	{
		this.user=user;
	}
	*/
	
	
}
