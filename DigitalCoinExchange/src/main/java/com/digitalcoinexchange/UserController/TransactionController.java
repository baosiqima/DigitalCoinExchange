package com.digitalcoinexchange.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.digitalcoinexchange.Domain.Transaction;
import com.digitalcoinexchange.Domain.User;
import com.digitalcoinexchange.Service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	@Autowired
	com.digitalcoinexchange.Repository.UserRepository us;

	@RequestMapping(method=RequestMethod.POST,value="/executeTranscation/{userId}")
	String executeTransaction(@RequestBody Transaction transaction,@PathVariable int userId)
	{
		User user=us.findByUserId(userId);
		transaction.setUser(user);
		return transactionService.execcuteTransaction(transaction);
	}
}
