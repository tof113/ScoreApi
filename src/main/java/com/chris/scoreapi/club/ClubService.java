package com.chris.scoreapi.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    public Iterable<Club> getClubs(){
        return clubRepository.findAll();
    }

    public Club createClub(ClubDto request){

    return null;
    }
}
