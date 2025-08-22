package com.onlinebooking.TicketBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "concerts")
public class Concert {

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

    @NotBlank(message = "Artist name is required")
    private String artistName;

    @NotBlank(message = "Artist photo URL is required")
    private String artistPhotoUrl;

    public Concert() {}

    public Concert(String title, String posterUrl, String dateTime, Integer runtime, String languages,
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

    // Getters and Setters
    // (Generate using IDE or Lombok if you prefer)
    // ...
}
