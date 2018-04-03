package com.digicoinexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digicoinexchange.dao.TransactionRepository;
import com.digicoinexchange.model.Transaction;


@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	public String execcuteTransaction(Transaction transaction) {
		
		transactionRepository.save(transaction);
		return "transaction executed";
	}

}
