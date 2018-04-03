package com.digicoinexchange.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digicoinexchange.dao.UserDao;
import com.digicoinexchange.model.Otp;
import com.digicoinexchange.service.OtpService;

@CrossOrigin
@RestController
public class OtpController {
	
	@Autowired
	OtpService authTokenService;
	
	@Autowired
	UserDao userRepository;
	
	@RequestMapping(method=RequestMethod.POST,value="/login/otp")
	HashMap<Object,Object> verifyAuthToken(@RequestBody Otp authtoken){
	 return authTokenService.verifyAuthToken(authtoken.getToken(),authtoken.getUser());
	}
	

}
