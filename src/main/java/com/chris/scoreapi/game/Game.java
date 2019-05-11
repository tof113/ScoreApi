package com.chris.scoreapi.game;


import com.chris.scoreapi.common.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Game extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int game;

    @NonNull
    private int team1;

    @NonNull
    private int team2;

    private int score1;

    private int score2;

    private LocalDateTime gameDate;

    private int season;
}
