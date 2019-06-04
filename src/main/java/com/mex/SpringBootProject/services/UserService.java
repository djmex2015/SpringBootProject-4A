package com.mex.SpringBootProject.services;

import com.mex.SpringBootProject.entities.UserEntity;
import com.mex.SpringBootProject.exceptions.MessageException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public UserEntity getUserByEmail(String email);

    public UserEntity saveUser(UserEntity user) throws MessageException;
}
