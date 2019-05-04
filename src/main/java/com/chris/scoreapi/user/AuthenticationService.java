package com.chris.scoreapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public String login(LoginRequest request) throws FailedLoginException {

        User user = userRepository.findByEmail(request.getEmail());

        if(user == null){
            throw new FailedLoginException("email not correct");
        }

        if(!user.getPassword().equals(request.getPassword())){
            throw new FailedLoginException("password invalid");
        }

        return "Login succesful : "+user.getFirstName() + " "+user.getLastName();
    }
}
