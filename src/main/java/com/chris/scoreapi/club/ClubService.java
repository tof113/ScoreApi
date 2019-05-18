package com.chris.scoreapi.club;

import com.chris.scoreapi.common.Translator;
import com.chris.scoreapi.common.exceptions.EntityNotFoundException;
import com.chris.scoreapi.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    public Iterable<Club> getClubs(){
        return clubRepository.findAll();
    }

    public Club getClubByName(String name){
        Club club = clubRepository.findByName(name);

        if(club == null){
            throw new EntityNotFoundException(Translator.toLocale("clubNotFound"));
        }
        return club;
    }

    public Club getClubById(Integer id){
        Club club = clubRepository.findByClub(id);

        if(club == null){
            throw new EntityNotFoundException(Translator.toLocale("clubNotFound"));
        }
        return club;
    }

    public Club createClub(User user, ClubDto request){

        Club club = new Club(user, request);
        club = clubRepository.save(club);

    return club;
    }


}
