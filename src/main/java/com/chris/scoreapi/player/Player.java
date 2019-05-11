package com.chris.scoreapi.player;


import com.chris.scoreapi.club.Club;
import com.chris.scoreapi.common.entity.BaseEntity;
import com.chris.scoreapi.team.Team;
import com.chris.scoreapi.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Player extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int player;

    @NonNull
    private String name;

    private String description;

    private String photo;

    //Relation Many-to-one to Club
    @NonNull
    @ManyToOne
    @JoinColumn(name="club")
    private Club club;

    //Relation many-to-many with Team
    @ManyToMany(mappedBy = "players")
    private Set<Team> teams = new HashSet<>();
}
