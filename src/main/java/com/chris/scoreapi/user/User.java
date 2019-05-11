package com.chris.scoreapi.user;

import com.chris.scoreapi.club.Club;
import com.chris.scoreapi.common.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

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

    //Relation many-to-many with Club
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "User_Club",
            joinColumns = {@JoinColumn(name = "user")},
            inverseJoinColumns = {@JoinColumn(name = "club")}
    )
    private Set<Club> clubs = new HashSet<>();

}
