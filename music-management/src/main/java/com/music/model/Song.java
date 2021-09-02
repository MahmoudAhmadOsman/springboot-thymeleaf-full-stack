package com.music.model;

public class Song {
    private  long id;
    private String name;
    private String artist;
    private String album;
    private int rating;
    private int year;

    public Song() {
    }

    public Song(long id, String name, String artist, String album, int rating, int year) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.rating = rating;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
