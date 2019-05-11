package com.chris.scoreapi.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.MappedSuperclass;
import java.time.*;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

    @NonNull
    private boolean deleted;
    @NonNull
    private LocalDateTime creationTime;
    @NonNull
    private LocalDateTime modificationTime;
}
