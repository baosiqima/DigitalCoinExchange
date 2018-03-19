package com.digitalcoinexchange.Service;

import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalcoinexchange.Domain.AuthToken;
import com.digitalcoinexchange.Domain.User;
import com.digitalcoinexchange.Repository.UserRepository;
import com.digitalcoinexchange.User.Security.SendEmail;
import com.digitalcoinexchange.User.Security.TokenGenerator;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired TokenGenerator tokengenerator;
	
	@Autowired
	AuthTokenService authtokenservice;
	
	
	public void addUser(User user) {
		
		userRepository.save(user);
		
	}

	public List<User>getUsers() {
		
		
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
		
	}

	public String verify(String username, String password) throws SQLException, InterruptedException {
		
		
		//System.out.println("login successful");
		
		 User user1= userRepository.findByUsername(username);
		
		 System.out.println(user1.getPassword());
		 
		 if(user1.getPassword().equals(password))
		 {
			 
			////String authtoken=tokengenerator.tokenGen(username, password);
		//	 System.out.println(authtoken);
			 String email=user1.getEmail();
			 String phone=user1.getPhone();
			 //new TokenGenerator(username,password,email,phone);
			 //AuthToken token = tokenService.getToken("one", "sdffsdf");
			String token=tokengenerator.TokenGenerator(username, password, email, phone);
			
			AuthToken authtoken=new AuthToken("1",token);
			authtokenservice.addauthToken(authtoken);
			
			Thread.currentThread().sleep(250000);
			authtokenservice.deleteAuthToken(authtoken);
			 
			// System.out.println(email);
			
			 String d=user1.getCountry();
			 
			return "login successful";
		 }
		 else
		 {
			 return "login failed";
		 }
		 	

		
		
		
	}

	
	
}
