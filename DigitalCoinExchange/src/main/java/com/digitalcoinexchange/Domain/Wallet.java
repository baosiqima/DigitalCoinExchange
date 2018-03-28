package com.digitalcoinexchange.Domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.digitalcoinexchange.Repository.WalletType;


@Entity
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int walletId;
	String walletPassword;
	String PrivateKey;
	double balance;
	double shadowBalance;
	WalletType walletType;
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
	
	public Wallet()
	{
		
	}
	/*
	public Wallet(int walletId, String walletPassword, String privateKey,int userId) {
		super();
		this.walletId = walletId;
		this.walletPassword = walletPassword;
		PrivateKey = privateKey;
		this.user=new User(userId,"","","","",false,"");
	}
	*/

	public Wallet(int walletId, String walletPassword, String privateKey, double balance, double shadowBalance,
			WalletType walletType, int userId) {
		super();
		this.walletId = walletId;
		this.walletPassword = walletPassword;
		PrivateKey = privateKey;
		this.balance = balance;
		this.shadowBalance = shadowBalance;
		this.walletType = walletType;
		this.user=new User(userId,"","","","",false,"");
	}

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public String getWalletPassword() {
		return walletPassword;
	}

	public void setWalletPassword(String walletPassword) {
		this.walletPassword = walletPassword;
	}

	public String getPrivateKey() {
		return PrivateKey;
	}

	public void setPrivateKey(String privateKey) {
		PrivateKey = privateKey;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getShadowBalance() {
		return shadowBalance;
	}

	public void setShadowBalance(double shadowBalance) {
		this.shadowBalance = shadowBalance;
	}

	public WalletType getWalletType() {
		return walletType;
	}

	public void setWalletType(WalletType walletType) {
		this.walletType = walletType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	

}
