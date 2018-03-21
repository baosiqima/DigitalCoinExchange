package com.digitalcoinexchange.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcoinexchange.Domain.Roles;
import com.digitalcoinexchange.Service.RolesService;

@RestController
public class RolesController {

	@Autowired
	RolesService rolesService;
	
	@RequestMapping(method=RequestMethod.POST,value="/createRoles")
	String createRoles(@RequestBody Roles roles)
	{
		return rolesService.addRoles(roles);
		
		
	}
}
