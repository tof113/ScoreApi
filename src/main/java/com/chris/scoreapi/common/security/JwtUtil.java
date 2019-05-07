package com.chris.scoreapi.common.security;


import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.chris.scoreapi.common.exceptions.JwtException;
import org.springframework.stereotype.Service;



@Service
public class JwtUtil {

    private final JWTSigner signer;
    private final JWTVerifier verifier;
    private final String audience;
    private final String issuer;

    public JwtUtil(){
        this.signer = new JWTSigner(JwtConstants.JWT_SECRET);
        this.verifier = new JWTVerifier(JwtConstants.JWT_SECRET, JwtConstants.JWT_AUDIANCE_USERS, JwtConstants.JWT_ISSUER);
        this.audience = JwtConstants.JWT_AUDIANCE_USERS;
        this.issuer = JwtConstants.JWT_ISSUER;
    }

    public JwtUtil(String secret, String audience, String issuer){
        this.signer = new JWTSigner(secret);
        this.verifier = new JWTVerifier(secret,audience,issuer);
        this.audience = audience;
        this.issuer = issuer;
    }

    public String sign (JwtClaims claims, Integer validSeconds) throws JwtException {
        try{
            claims.claim("aud", audience);
            claims.claim("iss", issuer);
            JWTSigner.Options options = new JWTSigner.Options();
            options.setExpirySeconds(validSeconds);
            options.setIssuedAt(true);

            return signer.sign(claims.getClaims(), options);
        }catch (Exception e){
            throw new JwtException("Jwt signature failed", e);
        }
    }

    public JwtClaims verify(String token) throws JwtException{
        try{
            return new JwtClaims(verifier.verify(token));
        }catch (Exception e){
            throw new JwtException("Jwt verification failed", e);
        }
    }


}
