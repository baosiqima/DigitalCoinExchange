package com.digicoinexchange.dao;

import org.springframework.data.repository.CrudRepository;

import com.digicoinexchange.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction,Integer> {
	
}
