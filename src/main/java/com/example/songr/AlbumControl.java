package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
@Controller
public class AlbumControl {

    @Autowired
    AlbumRepository albumRepository;


    @GetMapping("/album")
    public RedirectView addAlbum(){
        Album album1 = new Album("Blue Banisters", "Lana Del Rey","13", "61:53", "https://www.nme.com/wp-content/uploads/2021/07/lana-del-rey-blue-banister@2000x1270-696x442.jpg" );
        albumRepository.save(album1);
        Album album2 = new Album("Dirty Computer", "Janelle Monáe","13", "48:42", "https://upload.wikimedia.org/wikipedia/en/0/0b/DirtyComputer.png" );
        albumRepository.save(album2);
        Album album3 = new Album("Unsung Heroes", "Ensiferum","8", "61:19", "https://upload.wikimedia.org/wikipedia/en/a/a7/Ensiferum_-_Unsung_Heroes.jpg" );
        albumRepository.save(album3);

        return new RedirectView("/myalbums");
    }

    @GetMapping("/myalbums")
    public String getAllAlbums(Model model){
        List<Album> data = (ArrayList<Album>) albumRepository.findAll();
        model.addAttribute("albums", data);
        return "album";
    }

    @PostMapping("/myalbums")
    public RedirectView addAlbumToDB(Model model, @RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="songCount") String songCount, @RequestParam(value="length") String length, @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return new RedirectView("/myalbums");
    }

}