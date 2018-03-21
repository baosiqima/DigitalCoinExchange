package com.digitalcoinexchange.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalcoinexchange.Domain.BuyCoins;
import com.digitalcoinexchange.Repository.SellCoinsRepository;

@Service
public class SellCoinsService {

	@Autowired
	SellCoinsRepository sellCoinsRepository;
	public String buyCoins(BuyCoins sellCoins) {
	
	 sellCoinsRepository.save(sellCoins);
	 return "ur order is placed";
	}

	
	
}
