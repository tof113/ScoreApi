package com.chris.scoreapi.user;


import com.chris.scoreapi.common.exceptions.JwtException;
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
        }catch (JwtException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //-----SIGNUP-----
    @PostMapping(value = "/signup")
    public ResponseEntity<Object> signup(@RequestBody SignUpRequest request){
        try{
            return new ResponseEntity<>(authenticationService.signup(request), HttpStatus.ACCEPTED);
        }catch(IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }

    }
}
