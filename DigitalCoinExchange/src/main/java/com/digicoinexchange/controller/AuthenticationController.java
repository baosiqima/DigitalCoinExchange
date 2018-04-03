package com.digicoinexchange.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.digicoinexchange.config.JwtTokenUtil;
import com.digicoinexchange.dao.AuthTokenRepository;
import com.digicoinexchange.dao.UserDao;
import com.digicoinexchange.model.AuthToken;
import com.digicoinexchange.model.Constants;
import com.digicoinexchange.model.LoginUser;
import com.digicoinexchange.model.Otp;
import com.digicoinexchange.model.Role;
import com.digicoinexchange.model.User;
import com.digicoinexchange.service.OtpService;
import com.digicoinexchange.service.TokenGenerator;
import com.digicoinexchange.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;
    
    @Autowired 
    TokenGenerator tokengenerator;
    
    @Autowired
    OtpService otpService;
    
    @Autowired
    AuthTokenRepository authTokenRepository;
    
    @Autowired
    UserDao userRepository;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException, SQLException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        AuthToken aToken=new AuthToken();
        aToken.setUser(new User(user.getId(),"","","","",false,"",Role.USER));
        aToken.setToken(token);
        authTokenRepository.save(aToken);
        String otp=tokengenerator.TokenGenerator(user.getUsername(), user.getPassword(),user.getEmail(),user.getPhone());
        Otp newOtp=new Otp();
		newOtp.setUser(new User(user.getId(),"","","","",false,"",Role.USER));
		newOtp.setToken(otp);
		otpService.addauthToken(newOtp);
        return ResponseEntity.ok(new AuthToken(token));
    }
    
    @RequestMapping(value = "/logout/{id}", method = RequestMethod.GET)
    public String logout(@PathVariable long id)
    {
    	try
    	{
    		User user=userRepository.findById(id);
    		AuthToken authToken=authTokenRepository.findByUser(user);
    		authTokenRepository.delete(authToken);
    		return Constants.logoutSuccessMessage;
    	}
    	catch(Exception e)
    	{
    		return Constants.logoutFailedMessage;
    	}
    }
    

}
