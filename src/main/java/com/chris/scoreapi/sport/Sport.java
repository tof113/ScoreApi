package com.chris.scoreapi.sport;


import com.chris.scoreapi.club.Club;
import com.chris.scoreapi.common.entity.BaseEntity;
import com.chris.scoreapi.season.Season;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
public class Sport extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int sport;
    @NonNull
    private String name;

    //Relation many-to-many with Club
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Sport_Club",
            joinColumns = {@JoinColumn(name = "sport")},
            inverseJoinColumns = {@JoinColumn(name = "club")}
    )
    private Set<Club> clubs = new HashSet<>();

    //Relation One-to-Many with Season
    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL)
    private Set<Season> seasons;

    //Relation One-to-Many with Games
    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL)
    private Set<Season> games;

    public Sport(SportRequest request){
        this.name = request.getName();
        this.setCreationTime(LocalDateTime.now());
        this.setModificationTime(this.getCreationTime());
        this.setDeleted(false);

    }

}
