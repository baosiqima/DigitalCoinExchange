package com.digitalcoinexchange.Repository;

import org.springframework.data.repository.CrudRepository;

import com.digitalcoinexchange.Domain.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction,Integer> {
	
	

}
