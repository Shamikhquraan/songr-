package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SongControl {
    @Autowired
    SongCurd songCrud;
    @GetMapping("/albumsongs")

    public RedirectView addSong(){
        Song song1 = new Song("Fight Song", "7:10",1);
        songCrud.save(song1);
        Song song2 = new Song("Easy On Me", "9:10",2);
        songCrud.save(song2);
        return new RedirectView("/albumsong");
    }


    @GetMapping("/albumsong")
    public String getAlbumSongs(Model model){
        List<Song> data = (ArrayList<Song>) songCrud.findAll();
        model.addAttribute("songs", data);
        return "albumsongs";
    }


    @PostMapping("/albumsongs")
    public RedirectView addAlbumToDB(Model model, @RequestParam(value="title") String title, @RequestParam(value="trackNumber") int trackNumber,  @RequestParam(value="length") String length){
        Song song = new Song(title,length,trackNumber);
        songCrud.save(song);
        return new RedirectView("/albumsongs");
    }


}