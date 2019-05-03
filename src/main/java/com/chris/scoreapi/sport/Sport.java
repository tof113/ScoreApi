package com.chris.scoreapi.sport;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data
@NoArgsConstructor
public class Sport {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer sport;
    @NonNull
    private String name;
}
