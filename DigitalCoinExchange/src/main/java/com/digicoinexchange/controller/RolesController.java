package com.digicoinexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digicoinexchange.model.Roles;
import com.digicoinexchange.service.RolesService;

@RestController
public class RolesController {

	@Autowired
	RolesService rolesService;
	
	@RequestMapping(method=RequestMethod.POST,value="/roles")
	String createRoles(@RequestBody Roles roles){
		return rolesService.addRoles(roles);		
	}
}
