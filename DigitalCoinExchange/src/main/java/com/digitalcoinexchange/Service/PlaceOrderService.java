package com.digitalcoinexchange.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalcoinexchange.Domain.PlaceOrder;
import com.digitalcoinexchange.Repository.PlaceOrderRepository;

@Service
public class PlaceOrderService {
	
	@Autowired
	PlaceOrderRepository placeOrderRepository;
	public String buyCoins(PlaceOrder placeOrder) {
	
		placeOrderRepository.save(placeOrder);
	 return "ur order is placed";
	}

	
	

}
