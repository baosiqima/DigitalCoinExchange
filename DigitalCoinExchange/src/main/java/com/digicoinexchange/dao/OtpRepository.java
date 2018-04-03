package com.digicoinexchange.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.digicoinexchange.model.Otp;
import com.digicoinexchange.model.User;





public interface OtpRepository extends CrudRepository<Otp,String>{

	@Query
	public Otp findByUser(User user);
	public Otp findByAuthId(String authId);
	public Otp findByToken(String token);
}
