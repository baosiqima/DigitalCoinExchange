package com.digitalcoinexchange.Repository;

import org.springframework.data.repository.CrudRepository;

import com.digitalcoinexchange.Domain.AuthToken;



public interface AuthTokenRepository extends CrudRepository<AuthToken,String>{

	
}
