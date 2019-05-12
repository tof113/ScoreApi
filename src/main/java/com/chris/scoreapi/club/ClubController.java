package com.chris.scoreapi.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    //GET
    @GetMapping(value ="/all")
    public @ResponseBody Iterable<Club> getClubs(){
        Iterable<Club> clubs = clubService.getClubs();

        return clubs;

    }

    //POST
    @PostMapping(value = "/createSport")
    public @ResponseBody Club createClub(@RequestBody ClubDto request){
        return clubService.createClub(request);
    }



}
