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
	
	
	authTokenRepository.save(authtoken);
	
}



public void deleteAuthToken(AuthToken authtoken) {
	authTokenRepository.delete(authtoken);

	
	
}

/*

public AuthToken getAuthToken(int userId) {
	
	System.out.println(userId);
	///return authTokenRepository.findByUserId(userId);
	return authTokenRepository.findByuserId(userId);
	//return null;
}

*/

}
