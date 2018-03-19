package com.digitalcoinexchange.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcoinexchange.Domain.AuthToken;
import com.digitalcoinexchange.Service.AuthTokenService;

@RestController
public class AuthTokenController {
	
	@Autowired
	AuthTokenService authTokenService;
	
	//@RequestMapping(method=RequestMethod.POST,value="/post/AuthToken")
	public void addToken()
	{
		
	}

}
