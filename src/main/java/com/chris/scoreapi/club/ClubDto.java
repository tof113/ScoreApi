package com.chris.scoreapi.club;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class ClubDto {

    @NonNull
    private String name;

    private String description;

    private String photo;
}
