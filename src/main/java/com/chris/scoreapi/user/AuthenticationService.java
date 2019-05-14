package com.chris.scoreapi.user;

import com.chris.scoreapi.common.Translator;
import com.chris.scoreapi.common.exceptions.AuthenticationException;
import com.chris.scoreapi.common.exceptions.JwtException;
import com.chris.scoreapi.common.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public User signin(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername());

        if(user == null){
            throw new AuthenticationException("email not correct");
        }

        if(!PasswordEncrypt.isPasswordAndHashMatching(request.getPassword(), user.getPassword())){
            throw new AuthenticationException("password incorrect");
        }
        return user;
    }

    public User signup(SignUpRequest request) {

        User user = userRepository.findByUsername(request.getUsername());
        if(user != null){
            throw new IllegalArgumentException("Email already in use");
        }
        user = new User();
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(PasswordEncrypt.getHashFromString(request.getPassword()));
        Role role = roleRepository.findByName(request.getRole());
        if(role == null){
            role = roleRepository.save(new Role(request.getRole()));
        }
        user.getRoles().add(role);
        return userRepository.save(user);
    }

    /*public User getCurrentUser(){
        AppContext appContext = SecurityUtils.appContextAuthentication();
        if(appContext == null){
            throw new AuthenticationException(Translator.toLocale("authenticationFailed"));
        }
        return userRepository.findByUser(SecurityUtils.appContextAuthentication().getUserId());
    }*/



}
