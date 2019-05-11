package com.chris.scoreapi.player;


import com.chris.scoreapi.common.entity.BaseEntity;
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
public class Player extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int player;

    @NonNull
    private int club;

    @NonNull
    private String name;

    private String description;

    private String photo;
}
