

package com.digitalcoinexchange.User.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter 
{
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/login")
		.hasAnyRole("admin","user").and().formLogin().defaultSuccessUrl("/success");
	
	}
	
	@Autowired
	public void configuration(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().dataSource(dataSource)
		  .usersByUsernameQuery("select username, password, enabled"
			            + " from user where username=?")
		  	.authoritiesByUsernameQuery("select username,roles from role where username=?");
			        
		
		
		
	}
	
}