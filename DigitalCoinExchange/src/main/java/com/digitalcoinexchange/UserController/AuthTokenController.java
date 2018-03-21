package com.digitalcoinexchange.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcoinexchange.Service.AuthTokenService;

@CrossOrigin
@RestController
public class AuthTokenController {
	
	@Autowired
	AuthTokenService authTokenService;
	
	//@RequestMapping(method=RequestMethod.POST,value="/post/AuthToken")
	public void addToken()
	{
		
	}

}
