package com.chris.scoreapi.sport;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class SportRequest {

    @NonNull
    private String name;

}
