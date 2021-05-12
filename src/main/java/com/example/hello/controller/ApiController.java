package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   // 해당 Class는 Rest API를 처리하는 Controller
@RequestMapping("/api")    //RquestMapping URL를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello")
    public String Hello(){
        return  "Hello spring boot!";
    }
}
