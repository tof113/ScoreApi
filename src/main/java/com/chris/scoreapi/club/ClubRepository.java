package com.chris.scoreapi.club;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Integer> {

    Club findById(int clubId);
}
