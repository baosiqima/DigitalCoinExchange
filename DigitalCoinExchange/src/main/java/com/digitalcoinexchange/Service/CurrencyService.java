package com.digitalcoinexchange.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalcoinexchange.Domain.Currency;
import com.digitalcoinexchange.Repository.CurrencyRepository;

@Service
public class CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;
	public String addCurrency(Currency currency) {
		
		currencyRepository.save(currency);
		
		return "currency added";
		
	}

}
