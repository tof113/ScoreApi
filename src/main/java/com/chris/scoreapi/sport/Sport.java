package com.chris.scoreapi.sport;


import com.chris.scoreapi.common.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
public class Sport extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int sport;
    @NonNull
    private String name;

    public Sport(SportRequest request){
        this.name = request.getName();
        this.setCreationTime(LocalDateTime.now());
        this.setModificationTime(this.getCreationTime());
        this.setDeleted(false);

    }

}
