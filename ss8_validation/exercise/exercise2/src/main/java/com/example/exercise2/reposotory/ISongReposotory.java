package com.example.exercise2.reposotory;

import com.example.exercise2.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongReposotory extends JpaRepository<Song,Integer> {
}
