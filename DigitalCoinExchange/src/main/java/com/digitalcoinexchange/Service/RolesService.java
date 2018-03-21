package com.digitalcoinexchange.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalcoinexchange.Domain.Roles;
import com.digitalcoinexchange.Repository.RolesRepository;

@Service
public class RolesService {
	
	@Autowired
	RolesRepository rolesRepository;
	public String addRoles(Roles roles) {
		
		rolesRepository.save(roles);
		
		return "role added";
	}

}
