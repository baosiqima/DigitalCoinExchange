package com.digitalcoinexchange.UserController;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcoinexchange.Domain.User;
import com.digitalcoinexchange.Domain.Wallet;
import com.digitalcoinexchange.Service.WalletService;




@RestController
public class WalletController {

	
	@Autowired
	WalletService walletService;
	
	@RequestMapping(method=RequestMethod.POST,value="/createWallet")
	String createWallet() 
	{
		
		//wallet.setUser(new User(userId,"","","","",false,""));
		return walletService.createWallet();
		
	}
	
	
	
}
