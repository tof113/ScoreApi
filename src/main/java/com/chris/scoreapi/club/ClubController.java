package com.chris.scoreapi.club;

import com.chris.scoreapi.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping(value ="/all")
    public @ResponseBody Iterable<Club> getClubs(){
        Iterable<Club> clubs = clubService.getClubs();

        return clubs;

    }

    @PostMapping(value = "/createClub")
    public ResponseEntity<Object> createClub(@RequestBody ClubDto request){
        try{
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Club club = clubService.createClub(user, request);
            return new ResponseEntity<>(club, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }



}
