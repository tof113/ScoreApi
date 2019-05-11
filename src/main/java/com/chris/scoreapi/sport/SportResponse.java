package com.chris.scoreapi.sport;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class SportResponse {

    @NonNull
    private String name;

    public SportResponse(Sport sport){
        this.name = sport.getName();
    }
}
