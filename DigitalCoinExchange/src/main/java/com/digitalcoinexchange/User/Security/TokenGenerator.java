package com.digitalcoinexchange.User.Security;

import com.digitalcoinexchange.Service.AuthTokenService;
import com.digitalcoinexchange.UserController.AuthTokenController;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.digitalcoinexchange.User.Security.SendSms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.digitalcoinexchange.Domain.AuthToken;

@Service
public class TokenGenerator {
	

	@Autowired
	AuthTokenService authTokenService;
	
	String userName;
	String password,email,mobile;
	AuthToken authtoken;
	SendSms send=new SendSms();
		
	
	public String TokenGenerator(String userName,String password,String email,String mobile) throws SQLException
	{
	
		this.userName=userName;
		this.password=password;
		this.mobile=mobile;
		this.email=email;
		
		
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	String token;
	  token=this.userName+this.password;
	  System.out.println(token);
	  
	  
	 SendEmail sendEmail=new SendEmail(email,"AuthToken",token);
	 // send.m1(mobile, token);
	 return token;
	}
	
	
	public AuthToken getToken(String id,String token) {
		return new AuthToken(id,token);
	}
	
	
	
	
}
