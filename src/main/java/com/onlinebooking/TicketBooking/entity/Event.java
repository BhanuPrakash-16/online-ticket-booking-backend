package com.onlinebooking.TicketBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title is required")
    private String title;

    @Size(max = 512)
    private String posterUrl;

    @NotBlank(message = "Event datetime is required")
    private String dateTime; // Consider using `LocalDateTime` for better type safety

    @Min(value = 1, message = "Runtime must be at least 1 minute")
    private Integer runtime; // in minutes

    @Size(max = 255)
    private String languages;

    @Size(max = 255)
    private String genre;

    @NotBlank(message = "Location is required")
    private String location;

    @Size(max = 255)
    private String artistName;

    @Size(max = 512)
    private String artistPhotoUrl;

    public Event() {
    }

    public Event(String title, String posterUrl, String dateTime, Integer runtime, String languages,
                 String genre, String location, String artistName, String artistPhotoUrl) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.dateTime = dateTime;
        this.runtime = runtime;
        this.languages = languages;
        this.genre = genre;
        this.location = location;
        this.artistName = artistName;
        this.artistPhotoUrl = artistPhotoUrl;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistPhotoUrl() {
        return artistPhotoUrl;
    }

    public void setArtistPhotoUrl(String artistPhotoUrl) {
        this.artistPhotoUrl = artistPhotoUrl;
    }
}
