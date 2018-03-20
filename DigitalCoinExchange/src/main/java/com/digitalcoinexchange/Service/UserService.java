package com.digitalcoinexchange.Service;

import java.sql.SQLException;
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
	
	String result;
	String message;
	String userToken="";
	HashMap<String,String> h=new HashMap();
	HashMap<String,String> addUser=new HashMap();
	public HashMap<String,String> addUser(User user) {
		
		userRepository.save(user);
		result="Registration Successful";
		message="";
		addUser.put(result, message);
		 
		return addUser;
	}

	public List<User>getUsers() {
		
		
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
		
	}

	public HashMap<String,String> verify(String username, String password) throws SQLException, InterruptedException {
		
		
		//System.out.println("login successful");
		
		 User user1= userRepository.findByUsername(username);
		
		 System.out.println(user1.getPassword());
		 
		 if(user1.getPassword().equals(password))
		 {
			 

			 String email=user1.getEmail();
			 String phone=user1.getPhone();
			 int userId=user1.getuserId();

			String token=tokengenerator.TokenGenerator(username, password, email, phone);
			
			
			AuthToken authtoken=new AuthToken("1",token);
			authtoken.setUser(new User(user1.getuserId(),"","","","",false,""));
			authtokenservice.addauthToken(authtoken);
			
			
			System.out.println(user1.getuserId());
			//AuthToken auth=authtokenservice.getAuthToken(user1.getuserId());
			if(true)
			{
						
			result="Login successful";
			message="Welcome "+" "+username;
			h.put(result, message);
			 
			
			}
			
			else
			{
				result="Login Failed";
				message="Incorrect AuthToken ";
				h.put(result, message);
				
			}
			Thread.currentThread().sleep(25000);
			authtokenservice.deleteAuthToken(authtoken);
			return h;
		 }
		 else
		 {
			 result="Login failed";
				message="Incorrect username and password";
				h.put(result, message);
				 
				return h;
		 }
		 	

		
		
		
	}

	
	
}
