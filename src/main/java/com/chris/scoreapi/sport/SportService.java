package com.chris.scoreapi.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportService {


    @Autowired
    private SportRepository sportRepository;

    public Iterable<Sport> getSports(){
        return sportRepository.findAll();
    }

    public Sport getSport(String name){
        return sportRepository.findByName(name);
    }

    public Sport addSport(SportRequest request){

        Sport sport = new Sport(request);
        return sportRepository.save(sport);
    }
}
