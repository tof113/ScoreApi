package com.chris.scoreapi.season;

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
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int season;

    @NonNull
    private int club;

    @NonNull
    private String name;

    private String description;

    @NonNull
    private LocalDateTime startDate;

    private LocalDateTime endDate;


}


