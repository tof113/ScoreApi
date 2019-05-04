package com.chris.scoreapi.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.login.FailedLoginException;

@Controller
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    //-----LOGIN-----
    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request){
        try{
            return new ResponseEntity<>(authenticationService.login(request), HttpStatus.ACCEPTED);
        }catch(FailedLoginException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }

    }
}
