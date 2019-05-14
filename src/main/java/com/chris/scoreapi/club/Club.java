package com.chris.scoreapi.club;

import com.chris.scoreapi.common.entity.BaseEntity;
import com.chris.scoreapi.game.Game;
import com.chris.scoreapi.player.Player;
import com.chris.scoreapi.season.Season;
import com.chris.scoreapi.sport.Sport;
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
public class Club extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer club;

    @NonNull
    private String name;

    private String description;

    private String photo;

    //Relation many-to-many with User
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "clubs")
    private Set<User> users = new HashSet<>();

    //Relation many-to-many with Sport
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "clubs")
    private Set<Sport> sports = new HashSet<>();

    //Relation One-to-Many with Player
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "club", cascade = CascadeType.ALL)
    private Set<Player> players;

    //Relation One-to-Many with Team
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "club", cascade = CascadeType.ALL)
    private Set<Team> teams;

    //Relation One-to-Many with Season
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "club", cascade = CascadeType.ALL)
    private Set<Season> seasons;

    //Relation One-to-Many with Game
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "club", cascade = CascadeType.ALL)
    private Set<Game> games;

    public Club(User user, ClubDto dto ){
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.photo = dto.getPhoto();
        this.users.add(user);
    }

    @Override
    public String toString(){
        return name;
    }



}
