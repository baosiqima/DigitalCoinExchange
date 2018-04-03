package com.digicoinexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digicoinexchange.dao.RolesRepository;
import com.digicoinexchange.model.Roles;


@Service
public class RolesService {
	
	@Autowired
	RolesRepository rolesRepository;
	public String addRoles(Roles roles) {
		
		rolesRepository.save(roles);
		
		return "role added";
	}

}
