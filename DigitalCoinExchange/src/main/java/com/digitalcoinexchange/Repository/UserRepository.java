package com.digitalcoinexchange.Repository;

import org.springframework.data.repository.CrudRepository;

import com.digitalcoinexchange.Domain.User;



public interface UserRepository extends CrudRepository<User,String>{

	User findByUsername(String username);
	User findByUserId(int userId);
}
