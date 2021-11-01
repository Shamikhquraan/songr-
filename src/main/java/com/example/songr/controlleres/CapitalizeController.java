package com.example.songr.controlleres;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CapitalizeController {
    @GetMapping("/capitalize/{name}")
    public String capitalize(@PathVariable String name,Model model){
        model.addAttribute("name",name.toUpperCase());
        return "capitalize";
    }
}