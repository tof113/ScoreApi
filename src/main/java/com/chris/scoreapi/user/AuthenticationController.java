package com.chris.scoreapi.user;


import com.chris.scoreapi.common.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;


    //-----LOGIN-----
    @PostMapping(value = "/signin")
    public @ResponseBody JwtResponse   signin(@RequestBody LoginRequest request){
        User user = authenticationService.signin(request);
        String token = jwtTokenProvider.createToken(user.getUser().toString(), user.getUsername(), user.getRoles());

        Map<Object, Object> model = new HashMap<>();
        model.put("id", user.getUser());
        model.put("username", user.getUsername());
        model.put("token", token);
        JwtResponse response = new JwtResponse();
        response.setToken(token);
        response.setId(user.getUser().toString());
        response.setUsername(user.getUsername());
        return response;

    }

    //-----SIGNUP-----
    @PostMapping(value = "/signup")
    public ResponseEntity<Object> signup(@RequestBody SignUpRequest request){
        try{
            User user = authenticationService.signup(request);
            String token = jwtTokenProvider.createToken(user.getUser().toString(), user.getUsername(), user.getRoles());

            Map<Object, Object> model = new HashMap<>();
            model.put("id", user.getUser());
            model.put("username", user.getUsername());
            model.put("token", token);
            return new ResponseEntity<>( model, HttpStatus.OK);
        }catch(IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
