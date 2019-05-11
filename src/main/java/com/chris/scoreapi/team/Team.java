package com.chris.scoreapi.team;


import com.chris.scoreapi.club.Club;
import com.chris.scoreapi.common.entity.BaseEntity;
import com.chris.scoreapi.game.Game;
import com.chris.scoreapi.player.Player;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Team extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team;

    @NonNull
    private String name;

    private String description;

    private String photo;

    //Relation Many-to-one to Club
    @NonNull
    @ManyToOne
    @JoinColumn(name="club")
    private Club club;

    //Relation many-to-many with Player
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Team_Player",
            joinColumns = {@JoinColumn(name = "team")},
            inverseJoinColumns = {@JoinColumn(name = "player")}
    )
    private Set<Player> players = new HashSet<>();

    //Relation One-to-Many with Game - Home team
    @OneToMany(mappedBy = "team1", cascade = CascadeType.ALL)
    private Set<Game> gamesAsHome;

    //Relation One-to-Many with Game - Visitor team
    @OneToMany(mappedBy = "team2", cascade = CascadeType.ALL)
    private Set<Game> gamesAsVisitor;


}
