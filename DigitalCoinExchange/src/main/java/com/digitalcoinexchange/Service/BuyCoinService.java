package com.digitalcoinexchange.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.digitalcoinexchange.Domain.BuyCoins;
import com.digitalcoinexchange.Repository.BuyCoinsRepository;

@Service 
public class BuyCoinService {

	
	@Autowired
	BuyCoinsRepository buyCoinsRepository;
	public String buyCoins(BuyCoins buyCoins) {
	
	 buyCoinsRepository.save(buyCoins);
	 return "ur order is placed";
	}

	
	
	
	
}
