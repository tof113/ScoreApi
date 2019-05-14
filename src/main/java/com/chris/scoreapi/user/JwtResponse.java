package com.chris.scoreapi.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtResponse {

    private String id;

    private String username;

    private String token;

}
