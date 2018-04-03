package com.digicoinexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digicoinexchange.dao.PlaceOrderRepository;
import com.digicoinexchange.model.PlaceOrder;


@Service
public class PlaceOrderService {
	
	@Autowired
	PlaceOrderRepository placeOrderRepository;
	public String buyCoins(PlaceOrder placeOrder) {
	
		placeOrderRepository.save(placeOrder);
	 return "ur order is placed";
	}

	
	

}
