package com.chris.scoreapi.user;

import lombok.Data;

@Data
public class JwtResponse {

    private String token;

    public JwtResponse(String jwt){
        token = jwt;
    }
}
