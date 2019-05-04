package com.chris.scoreapi.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class LoginRequest {
    @NonNull
    private String email;
    @NonNull
    private String password;
}
