package com.chris.scoreapi;

import com.chris.scoreapi.common.Translator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return Translator.toLocale("hello");
    }
}
