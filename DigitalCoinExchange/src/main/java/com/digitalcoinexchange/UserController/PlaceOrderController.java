package com.digitalcoinexchange.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcoinexchange.Domain.PlaceOrder;
import com.digitalcoinexchange.Domain.User;
import com.digitalcoinexchange.Service.PlaceOrderService;

@CrossOrigin
@RestController
public class PlaceOrderController {

	@Autowired
	PlaceOrderService placeOrderService;
	
	@Autowired
	com.digitalcoinexchange.Repository.UserRepository us;
	
	@RequestMapping(method=RequestMethod.POST,value="/placeOrder/{userId}")
	String BuyCoins(@RequestBody PlaceOrder placeOrder,@PathVariable int userId)
	{	
		User user=us.findByUserId(userId);
		placeOrder.setUser(user);
		return placeOrderService.buyCoins(placeOrder);
		
	}
}
