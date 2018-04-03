package com.digicoinexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digicoinexchange.dao.UserDao;
import com.digicoinexchange.model.Transaction;
import com.digicoinexchange.model.User;
import com.digicoinexchange.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	UserDao us;

	@RequestMapping(method=RequestMethod.POST,value="/executeTranscation/{userId}")
	String executeTransaction(@RequestBody Transaction transaction,@PathVariable long userId){
		User user=us.findById(userId);
		transaction.setUser(user);
		return transactionService.execcuteTransaction(transaction);
	}
}
