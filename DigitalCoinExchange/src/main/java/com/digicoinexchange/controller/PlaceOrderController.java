package com.digicoinexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digicoinexchange.dao.UserDao;
import com.digicoinexchange.model.PlaceOrder;
import com.digicoinexchange.model.User;
import com.digicoinexchange.service.PlaceOrderService;

@CrossOrigin
@RestController
public class PlaceOrderController {

	@Autowired
	PlaceOrderService placeOrderService;
	
	@Autowired
	UserDao us;
	
	@RequestMapping(method=RequestMethod.POST,value="/placeOrder/{userId}")
	String BuyCoins(@RequestBody PlaceOrder placeOrder,@PathVariable long userId){	
		User user=us.findById(userId);
		placeOrder.setUser(user);
		return placeOrderService.buyCoins(placeOrder);	
	}
}
