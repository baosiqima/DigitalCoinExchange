package com.digitalcoinexchange.Service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.digitalcoinexchange.Domain.AuthToken;
import com.digitalcoinexchange.Domain.User;
import com.digitalcoinexchange.Repository.AuthTokenRepository;

@Service
public class AuthTokenService {
	
@Autowired
AuthTokenRepository authTokenRepository;



public void addauthToken(AuthToken authtoken) {
	
	
	authTokenRepository.save(authtoken);
	
}



public void deleteAuthToken(AuthToken authtoken) {
	authTokenRepository.delete(authtoken);

	
	
}


/*
public AuthToken getAuthToken(String authId) {
		//System.out.println(userId);
	///return authTokenRepository.findByUserId(userId);
	return authTokenRepository.findByAuthId(authId);
	
}

*/

public AuthToken getAuthToken(User user)
{
	 return authTokenRepository.findByUser(user);
	// return authTokenRepository.findbyUserId(userId);
}


/*

public AuthToken getAuthId(String id) {
	return authTokenRepository.findOne(id);
	
}
*/
}

