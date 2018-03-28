package com.digitalcoinexchange.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalcoinexchange.Domain.AuthToken;
import com.digitalcoinexchange.Domain.User;
import com.digitalcoinexchange.Repository.UserRepository;
import com.digitalcoinexchange.User.Security.TokenGenerator;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired TokenGenerator tokengenerator;
	
	@Autowired
	AuthTokenService authtokenservice;
	
	String result,message;
	String userToken="";
	HashMap<String,String> h=new HashMap<String,String>();
	
	HashMap<String,String> addUser=new HashMap<String,String>();
	public HashMap<String,String> addUser(User user) {
		
		userRepository.save(user);
		result="Registration Successful";
		
		addUser.put(result, message);
		 
		return addUser;
	}

	public List<User>getUsers() {
		
		
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
		
	}

	public HashMap<String,String> verify(String username, String password,String role) throws SQLException, InterruptedException {
		
		
		try
		{
			h.clear();
		 User user1= userRepository.findByUsername(username);
		
		 System.out.println(user1.getPassword());
		 
		 if(user1.getPassword().equals(password)&&role.equals("USER"))
		 {
			 
				 
				 String email=user1.getEmail();
				 String phone=user1.getPhone();
				
	
				String token=tokengenerator.TokenGenerator(username, password, email, phone);
				
				System.out.println(token);
				
				AuthToken authtoken=new AuthToken(token);
				authtoken.setUser(new User(user1.getUserId(),"","","","",false,""));
				authtokenservice.addauthToken(authtoken);
				
				
				System.out.println(user1.getUserId());
		
				
				AuthToken auth=authtokenservice.getAuthToken(user1);
	
				System.out.println(auth.getToken());
				
				if(auth.getToken()!=null)
				{	
					h.clear();		
					String loginStatus="LoginSuccessful";
					String message="LoginSuccessful";
					h.put(loginStatus, message);
				 
				
				}
				
				else
				{
					h.clear();
					String loginStatus="LoginFailed";
					String message="LoginFailed";
					h.put(loginStatus, message);
				}
			//Thread.currentThread().sleep(25000);
			//authtokenservice.deleteAuthToken(authtoken);
			
		 
			
			return h;
		 }
		
		 else
		 {
			 h.clear();
			 String loginStatus="LoginFailed";
			String	message="LoginFailed";
				h.put(loginStatus, message);
				 
				return h;
		 }
		}
		
		 catch(NullPointerException ne)
			{
				System.out.println("incorrect username");
				h.clear();
				String loginStatus="LoginFailed";
				String message="LoginFailed";
				h.put(loginStatus, message);
				 return h;
			}
		 	
		
		
		
		
	}

	
	
}
