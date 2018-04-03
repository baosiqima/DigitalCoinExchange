package com.digicoinexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digicoinexchange.model.Role;
import com.digicoinexchange.model.User;
import com.digicoinexchange.model.Wallet;
import com.digicoinexchange.service.WalletService;

@CrossOrigin
@RestController
public class WalletController {
	@Autowired
	WalletService walletService;
	
	@RequestMapping(method=RequestMethod.GET,value="/createWallet/{userId}")
	String createWallet( Wallet wallet,@PathVariable long userId) {
		wallet.setUser(new User(userId,"","","","",false,"",Role.USER));
		return walletService.createWallet(wallet);
	}
	
}
