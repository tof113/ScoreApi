package com.chris.scoreapi.common.security;

import java.util.HashMap;
import java.util.Map;

public class JwtClaims {

    private Map<String, Object> claims = new HashMap<>();

    public JwtClaims(){}

    public JwtClaims(Map<String,Object> claims){
        this.claims = claims;
    }

    public void claim(String key, Object value ){
        claims.put(key, value);
    }

    public Map<String,Object> getClaims(){
        return claims;
    }

    public Object getClaim(String key){
        return claims.get(key);
    }
}
