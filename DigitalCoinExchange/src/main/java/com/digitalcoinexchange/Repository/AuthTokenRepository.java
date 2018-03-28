package com.digitalcoinexchange.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.digitalcoinexchange.Domain.AuthToken;
import com.digitalcoinexchange.Domain.User;



public interface AuthTokenRepository extends CrudRepository<AuthToken,String>{

	@Query
	public AuthToken findByUser(User user);
	public AuthToken findByAuthId(String authId);
	public AuthToken findByToken(String token);
}
