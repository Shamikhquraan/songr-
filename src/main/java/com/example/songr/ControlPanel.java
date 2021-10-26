package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
@Controller
public class ControlPanel {

    @Autowired
    AlbumRepository albumRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String splash(){
        return "songr";
    }

    @GetMapping("/album")
    public RedirectView addAlbum(){
        Album album1 = new Album("Blue Banisters", "Lana Del Rey","13", "61:53", "https://www.nme.com/wp-content/uploads/2021/07/lana-del-rey-blue-banister@2000x1270-696x442.jpg" );
        albumRepository.save(album1);
        Album album2 = new Album("Dirty Computer", "Janelle Monáe","13", "48:42", "https://upload.wikimedia.org/wikipedia/en/0/0b/DirtyComputer.png" );
        albumRepository.save(album2);
        Album album3 = new Album("Unsung Heroes", "Ensiferum","8", "61:19", "https://upload.wikimedia.org/wikipedia/en/a/a7/Ensiferum_-_Unsung_Heroes.jpg" );
        albumRepository.save(album3);

        return new RedirectView("/listalbums");
    }

    @GetMapping("/listalbums")
    public String getAllAlbums(Model model){
        List<Album> listData = (ArrayList<Album>) albumRepository.findAll();
        model.addAttribute("albums", listData);
        return "album";
    }

    @PostMapping("/listalbums")
    public RedirectView addAlbumToDB(Model model, @RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="songCount") String songCount, @RequestParam(value="length") String length, @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return new RedirectView("/listalbums");
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