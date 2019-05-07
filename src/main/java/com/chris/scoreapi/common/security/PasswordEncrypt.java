package com.chris.scoreapi.common.security;


import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncrypt {

    private static final int BCRYPT_SALT_LVL = 10;

    public static String getHashFromString(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(BCRYPT_SALT_LVL));
    }

    public static boolean isPasswordAndHashMatching(String password, String hashPassword){
        return BCrypt.checkpw(password, hashPassword);
    }
}
