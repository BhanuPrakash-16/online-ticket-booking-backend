package com.onlinebooking.TicketBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "sports")
public class Sports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Poster URL is required")
    private String posterUrl;

    @NotBlank(message = "Date and time is required")
    private String dateTime;

    @NotNull(message = "Runtime is required")
    private Integer runtime;

    @NotBlank(message = "Languages are required")
    private String languages;

    @NotBlank(message = "Genre is required")
    private String genre;

    @NotBlank(message = "Location is required")
    private String location;

    public Sports() {}

    public Sports(String title, String posterUrl, String dateTime, Integer runtime,
                  String languages, String genre, String location) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.dateTime = dateTime;
        this.runtime = runtime;
        this.languages = languages;
        this.genre = genre;
        this.location = location;
    }

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

    // Getters and Setters
    
    // ...
}
