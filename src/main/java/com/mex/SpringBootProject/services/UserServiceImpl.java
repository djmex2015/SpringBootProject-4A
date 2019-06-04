package com.mex.SpringBootProject.services;

import com.mex.SpringBootProject.entities.UserEntity;
import com.mex.SpringBootProject.exceptions.MessageException;
import com.mex.SpringBootProject.repositories.IUserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service("userService")
public class UserServiceImpl implements UserService {

    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    IUserRepository usersRepository;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder,
            IUserRepository usersRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.usersRepository = usersRepository;
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        UserEntity userEntity = usersRepository.findByEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException(email);
        }
        return userEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = usersRepository.findByEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(),
                true, // Email verification status
                true, true,
                true, new ArrayList<>());
    }

    @Override
    public UserEntity saveUser(@RequestBody UserEntity user) throws MessageException {
        UserEntity userExists = usersRepository.findByEmail(user.getEmail());
        if (userExists != null) {
            throw new MessageException("User is already registered.");
        }
        user.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getEncryptedPassword()));
        return usersRepository.save(user);
    }
}
