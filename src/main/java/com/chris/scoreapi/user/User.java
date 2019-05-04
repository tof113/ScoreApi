package com.chris.scoreapi.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user;

    @NonNull
    private String lastName;

    @NonNull
    private String firstName;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private boolean admin;

}
