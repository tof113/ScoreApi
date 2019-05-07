package com.chris.scoreapi.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value ="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    //----GET----
    @GetMapping(value = "")
    public @ResponseBody User getUserBy(){
        return null;
    }

    @GetMapping(value ="/all")
    public @ResponseBody Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    //----POST-----
    //TODO : USE DAO to communicate with FE
    @PostMapping(value = "")
    public @ResponseBody User addNewUser(@RequestBody User userDAO){
        User user = userDAO;

        return userRepository.save(user);
    }
}
