package com.chris.scoreapi.game;


import com.chris.scoreapi.club.Club;
import com.chris.scoreapi.common.entity.BaseEntity;
import com.chris.scoreapi.season.Season;
import com.chris.scoreapi.sport.Sport;
import com.chris.scoreapi.team.Team;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Game extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int game;

    //Relation Many-to-one to Club
    @NonNull
    @ManyToOne
    @JoinColumn(name="club")
    private Club club;

    //Relation Many-to-one to Club
    @NonNull
    @ManyToOne
    @JoinColumn(name="sport")
    private Sport sport;

    //Relation Many-to-one to Team
    @NonNull
    @ManyToOne
    @JoinColumn(name="team1")
    private Team team1;

    //Relation Many-to-one to Team
    @NonNull
    @ManyToOne
    @JoinColumn(name="team2")
    private Team team2;

    //Relation Many-to-one to Season
    @NonNull
    @ManyToOne
    @JoinColumn(name="season")
    private Season season;

    private int score1;

    private int score2;

    private LocalDateTime gameDate;


}
