package com.chris.scoreapi.club;

import com.chris.scoreapi.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping(value ="/all")
    public ResponseEntity<Object> getClubs(){
        Iterable<Club> clubs = clubService.getClubs();
        Set<ClubDto> response = new HashSet<>();
        for(Club c : clubs){
            response.add(new ClubDto(c));
        }
        return new ResponseEntity<>( response, HttpStatus.OK);
    }

    @GetMapping(value ="", params = "name")
    public ResponseEntity<Object> getClubByName(@RequestParam String name){
        Club club = clubService.getClubByName(name);
        ClubDto response = new ClubDto(club);
        return new ResponseEntity<>( response, HttpStatus.OK);
    }

    @GetMapping(value ="", params = "id")
    public ResponseEntity<Object> getClubById(@RequestParam Integer id){
        Club club = clubService.getClubById(id);
        ClubDto response = new ClubDto(club);
        return new ResponseEntity<>( response, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createClub(@RequestBody ClubDto request){
        try{
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Club club = clubService.createClub(user, request);
            ClubDto response = new ClubDto(club);
            return new ResponseEntity<>( response, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }



}
