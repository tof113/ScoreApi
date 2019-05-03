package com.chris.scoreapi.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/sport")
public class SportController {

    @Autowired
    private SportRepository sportRepository;

    @GetMapping(value = "/all")
    public @ResponseBody Iterable<Sport> getSports(){
        return sportRepository.findAll();
    }

    @GetMapping(value = "")
    public @ResponseBody Sport getSport(@RequestParam String name){
        return sportRepository.findByName(name);
    }
}
