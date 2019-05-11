package com.chris.scoreapi.season;

import com.chris.scoreapi.club.Club;
import com.chris.scoreapi.sport.Sport;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int season;

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

    //Relation One-to-Many with Games
    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
    private Set<Season> games;

    @NonNull
    private String name;

    private String description;

    @NonNull
    private LocalDateTime startDate;

    private LocalDateTime endDate;


}


