package com.digicoinexchange.service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digicoinexchange.model.Otp;

import java.util.Random;
@Service
public class TokenGenerator {
	@Autowired
	OtpService otpService;

	String userName;
	String password,email,mobile;
	Otp authtoken;
	SendSms send=new SendSms();
	
	public String TokenGenerator(String userName,String password,String email,String mobile) throws SQLException{
		this.userName=userName;
		this.password=password;
		this.mobile=mobile;
		this.email=email;

		Random rand = new Random();
		String token=rand.nextInt()+"";
		 
		new SendEmail(email,"AuthToken",token);
		//send.sendSms(mobile, token);
		
		return token;
	}
		
	public Otp getToken(String id,String token) {
		return new Otp(token);
	}




}
