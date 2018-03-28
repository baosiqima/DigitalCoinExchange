package com.digitalcoinexchange.Service;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.digitalcoinexchange.Domain.AuthToken;
import com.digitalcoinexchange.Domain.User;
import com.digitalcoinexchange.Repository.AuthTokenRepository;
import com.digitalcoinexchange.User.Security.TokenGenerator;

@Service
public class AuthTokenService {
	
@Autowired
AuthTokenRepository authTokenRepository;

AuthTokenService authTokenService;
@Autowired
TokenGenerator tokenGenerator;

public String createAuthToken(String username,String password,String email,String phone) throws SQLException{
	
	System.out.println(username);
	return tokenGenerator.TokenGenerator(username, password, email, phone);

}

public void addauthToken(AuthToken authtoken) {
	
	
	authTokenRepository.save(authtoken);
	
}



public void deleteAuthToken(AuthToken authtoken) {
	authTokenRepository.delete(authtoken);

	
	
}



public AuthToken getAuthToken(User user)
{
	 return authTokenRepository.findByUser(user);

}


public HashMap<Object,Object> verifyAuthToken(String authToken,User user){
	
	HashMap<Object,Object> h=new HashMap<Object,Object>();
	try {
		AuthToken auth=authTokenRepository.findByToken(authToken);
		user=auth.getUser();
		
		String message;
		String loginStatus;
	
		List<Object> l=new ArrayList<Object>();
	if(auth.getToken().equals(authToken))
		{
		l.clear();
		h.clear();

		 message="loginSuccessful";
		 loginStatus="loginSuccessful";	
		 h.put(loginStatus,message);
		 h.put("username",user.getUsername());
		 h.put("userId",user.getUserId());
		 h.put("phone",user.getPhone());
		 h.put("email",user.getEmail());
		 h.put("country",user.getCountry());

		 return h;
	
		}
	
	else
	{

		message="IncorrectAuthToken";
		loginStatus="loginFailed";
		h.put(loginStatus,message);
		 
		return h;
	}
	
	}
	catch(NullPointerException ne)
	{
		 h.clear();
		 String message="loginFailed";
		 String loginStatus="loginFailed";	
		 h.put(loginStatus,message);
		 return h;
	}

	
}
}

