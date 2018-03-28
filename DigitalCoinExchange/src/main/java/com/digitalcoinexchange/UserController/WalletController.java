package com.digitalcoinexchange.UserController;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcoinexchange.Domain.Role;
import com.digitalcoinexchange.Domain.User;
import com.digitalcoinexchange.Domain.Wallet;
import com.digitalcoinexchange.Service.WalletService;



@CrossOrigin
@RestController
public class WalletController {

	
	@Autowired
	WalletService walletService;
	
	@RequestMapping(method=RequestMethod.GET,value="/createWallet/{userId}")
	String createWallet( Wallet wallet,@PathVariable int userId) 
	{
		
		
		
		wallet.setUser(new User(userId,"","","","",false,"",Role.USER));
		
		return walletService.createWallet(wallet);
		
	}
	
	
	
}
