package com.example.exercise2.service.impl;

import com.example.exercise2.model.Song;
import com.example.exercise2.reposotory.ISongReposotory;
import com.example.exercise2.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongReposotory iSongReposotory;
    @Override
    public Iterable<Song> findAll(Pageable pageable) {
        return iSongReposotory.findAll(pageable);
    }

    @Override
    public Optional<Song> findById(int id) {
        return iSongReposotory.findById(id);
    }

    @Override
    public void save(Song song) {
        iSongReposotory.save(song);
    }

    @Override
    public void remove(int id) {
        iSongReposotory.deleteById(id);
    }
}
