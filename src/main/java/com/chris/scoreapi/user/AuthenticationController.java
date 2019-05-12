package com.chris.scoreapi.user;


import com.chris.scoreapi.common.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public ResponseEntity<Object> signin(@RequestBody LoginRequest request){
        User user = authenticationService.signin(request);
        String token = jwtTokenProvider.createToken(user.getUser().toString(), user.getEmail(), user.getUsername());

        Map<Object, Object> model = new HashMap<>();
        model.put("id", user.getUser());
        model.put("email", user.getEmail());
        model.put("token", token);
        return new ResponseEntity<>( model, HttpStatus.ACCEPTED);

    }

    //-----SIGNUP-----
    @PostMapping(value = "/signup")
    public ResponseEntity<Object> signup(@RequestBody SignUpRequest request){
        try{
            User user = authenticationService.signup(request);
            String token = jwtTokenProvider.createToken(user.getUser().toString(), user.getEmail(), user.getUsername());

            Map<Object, Object> model = new HashMap<>();
            model.put("id", user.getUser());
            model.put("email", user.getEmail());
            model.put("token", token);
            return new ResponseEntity<>( model, HttpStatus.ACCEPTED);
        }catch(IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
