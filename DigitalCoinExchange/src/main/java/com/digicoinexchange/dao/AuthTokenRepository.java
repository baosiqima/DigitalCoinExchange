package com.digicoinexchange.dao;

import org.springframework.data.repository.CrudRepository;

import com.digicoinexchange.model.AuthToken;
import com.digicoinexchange.model.User;

public interface AuthTokenRepository extends CrudRepository<AuthToken, String> {

	AuthToken findByUser(User user);
	
	
}
