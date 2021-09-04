package com.music.model;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "songs")
public class Song {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    @NotNull
    @Size(min=3, max=20)
    private String name;
    @NotNull
    private String artist;

    @NotNull
    private String album;

    @NotNull
    private int rating;

    @NotNull
    private int year;

    @NotNull
    @Min(3)
    @Max(300)
    private String details;

    public Song() {
    }

    public Song(long id, String name, String artist, String album, int rating, int year, String details) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.rating = rating;
        this.year = year;
        this.details = details;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
