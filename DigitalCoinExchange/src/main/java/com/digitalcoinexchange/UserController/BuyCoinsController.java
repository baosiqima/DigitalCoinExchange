package com.digitalcoinexchange.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.digitalcoinexchange.Domain.BuyCoins;
import com.digitalcoinexchange.Domain.User;
import com.digitalcoinexchange.Service.BuyCoinService;

@CrossOrigin
@RestController
public class BuyCoinsController {

	@Autowired
	BuyCoinService buyCoinService;
	
	@Autowired
	com.digitalcoinexchange.Repository.UserRepository us;
	
	@RequestMapping(method=RequestMethod.POST,value="/buyCoins/{userId}")
	String BuyCoins(@RequestBody BuyCoins buyCoins,@PathVariable int userId)
	{	
		User user=us.findByUserId(userId);
		buyCoins.setUser(user);
		return buyCoinService.buyCoins(buyCoins);
		
	}
	
}
