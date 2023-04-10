package com.example.exercise2.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {

    private int id;
    @NotEmpty(message = "{NotEmpty}")
    @Size(max = 800)
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",message = "{NotRegex}")
    private String songName;
    @NotEmpty(message = "{NotEmpty}")
    @Size(max = 300)
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",message = "{NotRegex}")
    private String artist;
    @NotEmpty(message = "{NotEmpty}")
    @Size(max = 1000)
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",message = "{NotRegex}")
    private String category;

    public SongDto(int id, String songName, String artist, String category) {
        this.id = id;
        this.songName = songName;
        this.artist = artist;
        this.category = category;
    }

    public SongDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
