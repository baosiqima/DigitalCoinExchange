package com.digicoinexchange.service;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.digicoinexchange.dao.OtpRepository;
import com.digicoinexchange.model.Constants;
import com.digicoinexchange.model.Otp;
import com.digicoinexchange.model.User;


@Service
public class OtpService {
	
@Autowired
OtpRepository authTokenRepository;

OtpService authTokenService;
@Autowired
TokenGenerator tokenGenerator;

public String createAuthToken(String username,String password,String email,String phone) throws SQLException{
	
	System.out.println(username);
	return tokenGenerator.TokenGenerator(username, password, email, phone);

}

public void addauthToken(Otp authtoken) {
	authTokenRepository.save(authtoken);
	
}

public void deleteAuthToken(Otp authtoken) {
	authTokenRepository.delete(authtoken);
	
}

public Otp getAuthToken(User user){
	 return authTokenRepository.findByUser(user);

}


public HashMap<Object,Object> verifyAuthToken(String authToken,User user){
	
	HashMap<Object,Object> h=new HashMap<Object,Object>();
	try {
		Otp auth=authTokenRepository.findByToken(authToken);
		user=auth.getUser();
	  	List<Object> l=new ArrayList<Object>();
	if(auth.getToken().equals(authToken)){
		 l.clear();
		 h.clear();
		 h.put(Constants.loginSuccessStatus,Constants.loginSuccessMessage);
		 h.put("username",user.getUsername());
		 h.put("userId",user.getId());
		 h.put("phone",user.getPhone());
		 h.put("email",user.getEmail());
		 h.put("country",user.getCountry());

		 return h;
	
		}
	
	else{
		h.clear();
		h.put(Constants.loginFailedStatus,Constants.loginFailedMessage);
		return h;
	}
	
	}
	catch(NullPointerException ne){
		 h.clear();
		 h.put(Constants.loginFailedStatus,Constants.loginFailedMessage);
		 return h;
	}

	
}
}

