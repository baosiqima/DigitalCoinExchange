package com.digitalcoinexchange.UserController;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcoinexchange.Domain.AuthToken;
import com.digitalcoinexchange.Repository.UserRepository;
import com.digitalcoinexchange.Service.AuthTokenService;

@CrossOrigin
@RestController
public class AuthTokenController {
	
	@Autowired
	AuthTokenService authTokenService;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.POST,value="/login/authtoken")
	HashMap<Object,Object> verifyAuthToken(@RequestBody AuthToken authtoken)
	{

		System.out.println(authtoken.getToken());
		
	 return authTokenService.verifyAuthToken(authtoken.getToken(),authtoken.getUser());

	}
	

}
