package com.digitalcoinexchange.Domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int walletId;
	String walletPassword;
	String PrivateKey;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
	
	public Wallet()
	{
		
	}
	public Wallet(int walletId, String walletPassword, String privateKey) {
		super();
		this.walletId = walletId;
		this.walletPassword = walletPassword;
		PrivateKey = privateKey;
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
	
	
	
	

}
