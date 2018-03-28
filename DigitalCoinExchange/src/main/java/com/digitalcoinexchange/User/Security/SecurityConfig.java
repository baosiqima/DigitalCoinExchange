/*package com.digitalcoinexchange.User.Security;


import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.util.List;

//import com.digitalcoinexchange.User.Service.UserService;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import com.digitalcoinexchange.Domain.User;
 
@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
	DataSource dataSource;
	private JdbcTemplate jdbcTemplate;  
	
	String username="Gursahib Singh";
	String pass="1234";
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	
	
	JdbcUserDetailsManagerConfigurer user=auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password,enabled from user where username=?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	
	
		String sql="select username,password from user where username='"+"username"+"'";
		
		List l=jdbcTemplate.queryForList(sql);
		System.out.println(l);
		if(l.get(0)==username &&l.get(1)==pass)
		{
			String sql1="select email from user where username='"+username+"'";
			List l1=jdbcTemplate.queryForList(sql1);
			System.out.println(l1);
			
		}
		
	
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password,enabled from user where username=?").
		authoritiesByUsernameQuery("select username, role from user_roles where username=?").and()
		
		
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user/**").permitAll().antMatchers("/roles").hasRole("USER")
				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
				.permitAll();
		
		
		http.csrf().disable().authorizeRequests().antMatchers("/user/**").hasRole("USER").and().formLogin();
		//http.exceptionHandling().accessDeniedPage("/403");
	}
}*/
