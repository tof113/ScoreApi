package com.chris.scoreapi.club;

import com.chris.scoreapi.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

@Data
@NoArgsConstructor
public class ClubDto {

    private Integer club;

    @NonNull
    private String name;

    private String description;

    private String photo;

    private Set<Integer> users;

    public ClubDto(Club club ){
        this.club = club.getClub();
        this.name = club.getName();
        this.description = club.getDescription();
        this.photo = club.getPhoto();
    }
}
