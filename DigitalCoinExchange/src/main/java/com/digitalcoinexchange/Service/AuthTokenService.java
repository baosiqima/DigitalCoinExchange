package com.digitalcoinexchange.Service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.digitalcoinexchange.Domain.AuthToken;
import com.digitalcoinexchange.Repository.AuthTokenRepository;

@Service
public class AuthTokenService {
	
@Autowired
AuthTokenRepository authTokenRepository;



public void addauthToken(AuthToken authtoken) {
	//System.out.println("ssssssssssss"+authtoken.getToken());
	
	//AuthToken authtoken=new AuthToken("5","kuchv");
	//System.out.println(authtoken.getId()+authtoken.getToken());
	
	
	authTokenRepository.save(authtoken);
	
}



public void deleteAuthToken(AuthToken authtoken) {
	authTokenRepository.delete(authtoken);

	
	
}



}
