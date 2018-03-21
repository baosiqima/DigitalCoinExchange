package com.digitalcoinexchange.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalcoinexchange.Domain.Wallet;
import com.digitalcoinexchange.Repository.WalletRepository;

@Service
public class WalletService {

	@Autowired
	WalletRepository walletRepository;
	
	public String createWallet() {
		
		Object o=new Object();
		
		return "wallet created"+"  " + "your wallet key is" +" "+o.toString();
		
	}

}
