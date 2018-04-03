package com.digicoinexchange.service;

import java.util.List;

import com.digicoinexchange.model.User;
import com.digicoinexchange.model.UserDto;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}
