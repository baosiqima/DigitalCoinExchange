package com.digicoinexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digicoinexchange.dao.CurrencyRepository;
import com.digicoinexchange.model.Currency;



@Service
public class CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;
	public String addCurrency(Currency currency) {
		
		currencyRepository.save(currency);
		
		return "currency added";
		
	}

}
