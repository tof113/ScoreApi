package com.chris.scoreapi.common.security;

public class JwtConstants {

    public static final String JWT_HEADER_NAME = "Authorization";
    public static final String JWT_HEADER_VALUE_PREFIX = "Bearer";
    public static final String JWT_SECRET = "test_jwt_secret";
    public static final String JWT_ISSUER = "R1D2";
    public static final String JWT_AUDIANCE_USERS = "R1D2/isers";

    public static final String JWT_CLAIM_USER_ID = "userId";
    public static final String JWT_CLAIM_EMAIL_ADDRESS = "email";
}
