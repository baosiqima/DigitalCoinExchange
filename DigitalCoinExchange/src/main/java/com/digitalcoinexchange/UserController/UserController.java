package com.digitalcoinexchange.UserController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import com.digitalcoinexchange.EncryptPassword.EncryptPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcoinexchange.Domain.AuthToken;
import com.digitalcoinexchange.Domain.User;
import com.digitalcoinexchange.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userservice;

	EncryptPassword encryptPassword=new EncryptPassword();
	@RequestMapping("/user")
	String m1()
	{
		return "welcome user";
	}
	
	@RequestMapping("/roles")
	String m2()
	{
		return "roles";
	}
	/*
	@RequestMapping("/login/{username}/{password}")
	String m3(@PathVariable String username,@PathVariable String password) throws SQLException, InterruptedException
	{
		return userservice.verify(username,encryptPassword.encryptPassword(password));
		
		}
	*/
	/*@RequestMapping(method=RequestMethod.POST,value="/logins")
	String m3(@RequestBody User user) throws SQLException, InterruptedException 
	{
		
		String username=user.getUsername();
		String password=user.getPassword();
		return userservice.verify(username,encryptPassword.encryptPassword(password));
		
		
		} */
	
	
	@RequestMapping(method=RequestMethod.POST,value="/logins")
	HashMap<String,String> m3(@RequestBody User user) throws SQLException, InterruptedException 
	{
		
		String username=user.getUsername();
		String password=user.getPassword();
		return userservice.verify(username,encryptPassword.encryptPassword(password));
		
		
		}
	@RequestMapping(method=RequestMethod.POST,value="/post")
	public HashMap<String,String> addUser(@RequestBody User user)
	{
		String pass=user.getPassword();
		
		String encrPass=encryptPassword.encryptPassword(pass);
		user.setPassword(encrPass);
		return userservice.addUser(user);
		
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET,value="/get")
	public List<User> getUsers()
	{
		return userservice.getUsers();
		
	}
	
}
