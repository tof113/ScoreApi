package com.chris.scoreapi.user;

import com.chris.scoreapi.common.exceptions.AuthenticationException;
import com.chris.scoreapi.common.exceptions.JwtException;
import com.chris.scoreapi.common.security.JwtClaims;
import com.chris.scoreapi.common.security.JwtConstants;
import com.chris.scoreapi.common.security.JwtUtil;
import com.chris.scoreapi.common.security.PasswordEncrypt;
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
    private JwtUtil jwtUtil;

    public JwtResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if(user == null){
            throw new AuthenticationException("email not correct");
        }

        if(!PasswordEncrypt.isPasswordAndHashMatching(request.getPassword(), user.getPassword())){
            throw new AuthenticationException("password incorrect");
        }
        String jwt = generateJwtToken(user);

        return new JwtResponse(jwt);
    }

    public User signup(SignUpRequest request) {

        User user = userRepository.findByEmail(request.getEmail());
        if(user != null){
            throw new IllegalArgumentException("Email already in use");
        }
        user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(PasswordEncrypt.getHashFromString(request.getPassword()));
        user.setAdmin(true);

        return userRepository.save(user);
    }

    private String generateJwtToken(User user){
        String jwt = null;
        JwtClaims jwtClaims = new JwtClaims();
        jwtClaims.claim(JwtConstants.JWT_CLAIM_USER_ID, user.getUser());
        jwtClaims.claim(JwtConstants.JWT_CLAIM_EMAIL_ADDRESS, user.getEmail());
        return jwt = jwtUtil.sign(jwtClaims, 3600* 24 * 7);


    }
}
