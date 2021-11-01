package com.example.songr.controlleres;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongrController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/")
    public String home(){
        return "home";
    }
}