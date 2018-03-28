package com.digitalcoinexchange.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalcoinexchange.Domain.Transaction;
import com.digitalcoinexchange.Repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	public String execcuteTransaction(Transaction transaction) {
		
		transactionRepository.save(transaction);
		return "transaction executed";
	}

}
