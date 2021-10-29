package com.example.songr;

import org.springframework.data.repository.CrudRepository;

public interface SongCurd extends CrudRepository<Song, Long> {


}