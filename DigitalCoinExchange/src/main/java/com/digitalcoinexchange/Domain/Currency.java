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
	private CurrencyType currency;
	

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "walletId")
    private Wallet wallet;

	public Currency()
	{
		
	}

	public Currency(int id, CurrencyType currency, Wallet wallet) {
		super();
		this.id = id;
		this.currency = currency;
		this.wallet = wallet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CurrencyType getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyType currency) {
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
