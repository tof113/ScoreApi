package com.chris.scoreapi.sport;

import com.chris.scoreapi.user.AuthenticationService;
import com.chris.scoreapi.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/sport")
public class SportController {

    @Autowired
    private SportService sportService;

    @Autowired
    private AuthenticationService authenticationService;

    //----GET----
    @GetMapping(value = "/all")
    public @ResponseBody Iterable<SportResponse> getSports(){
        Iterable<Sport> sports = sportService.getSports();

        //TODO transform sport->SportResponse
        return null;

    }

    @GetMapping(value = "")
    public @ResponseBody SportResponse getSport(@RequestParam String name){
        return new SportResponse(sportService.getSport(name));
    }

    //----POST-----
    //TODO : USE DAO to communicate with FE
    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody SportResponse addNewSport( @RequestBody SportRequest request){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new SportResponse(sportService.addSport(request));
    }
}
