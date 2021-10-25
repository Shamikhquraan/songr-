package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//how
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
@Controller
public class ControlPanel {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String splash(){

        return "songr";
    }

    @RequestMapping(value = "/album", method = RequestMethod.GET)
    public String album(Model model){
        List<Album> data = new ArrayList<>();
        Album album1 = new Album("Blue Banisters", "Lana Del Rey","13", "61:53", "https://www.nme.com/wp-content/uploads/2021/07/lana-del-rey-blue-banister@2000x1270-696x442.jpg" );
        data.add(album1);
        Album album2 = new Album("Dirty Computer", "Janelle Monáe","13", "48:42", "https://upload.wikimedia.org/wikipedia/en/0/0b/DirtyComputer.png" );
        data.add(album2);
        Album album3 = new Album("Unsung Heroes", "Ensiferum","8", "61:19", "https://upload.wikimedia.org/wikipedia/en/a/a7/Ensiferum_-_Unsung_Heroes.jpg" );
        data.add(album3);
        model.addAttribute("albums", data);
        return "album";
    }
    @GetMapping("/hello")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }
    @GetMapping("/capitalize/{input}")
    @ResponseBody
    public String capitalizer(@PathVariable String input){
        return input.toUpperCase(Locale.ROOT);
    }



}