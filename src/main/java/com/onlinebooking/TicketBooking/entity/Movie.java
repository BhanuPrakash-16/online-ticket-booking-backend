package com.onlinebooking.TicketBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "moviedetails")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @NotNull
    @Min(1888)
    @Max(9999)
    @Column(name = "year")
    private Integer year;

    @Size(max = 50)
    @Column(name = "rated", length = 50)
    private String rated;

    @Column(name = "released")
    private LocalDate released;

    @Size(max = 50)
    @Column(name = "runtime", length = 50)
    private String runtime;

    @Size(max = 255)
    @Column(name = "genre", length = 255)
    private String genre;

    @Size(max = 255)
    @Column(name = "director", length = 255)
    private String director;

    @Size(max = 255)
    @Column(name = "languages", length = 255)
    private String languages;

    @Size(max = 1000)
    @Column(name = "poster_url", length = 1000)
    private String posterUrl;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("10.0")
    @Column(name = "imdb_rating")
    private Double imdbRating;

    @Size(max = 50)
    @Column(name = "imdb_id", length = 50)
    private String imdbId;

    @Size(max = 50)
    @Column(name = "type", length = 50)
    private String type;

    @Size(max = 1000)
    @Column(name = "writer", length = 1000)
    private String writer;

    @Size(max = 1000)
    @Column(name = "actors", length = 1000)
    private String actors;

    @Size(max = 2000)
    @Column(name = "plot", length = 2000)
    private String plot;

    @Lob
    @Column(name = "ratings", columnDefinition = "TEXT")
    private String ratings;

    public Movie() {
    }

    public Movie(String title, Integer year, Double imdbRating) {
        this.title = title;
        this.year = year;
        this.imdbRating = imdbRating;
    }

    public Movie(String title, Integer year, String rated, LocalDate released, String runtime, String genre,
                 String director, String languages, String posterUrl, Double imdbRating, String imdbId,
                 String type, String writer, String actors, String plot, String ratings) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.languages = languages;
        this.posterUrl = posterUrl;
        this.imdbRating = imdbRating;
        this.imdbId = imdbId;
        this.type = type;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.ratings = ratings;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", rated='" + rated + '\'' +
                ", released=" + released +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", languages='" + languages + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", imdbRating=" + imdbRating +
                ", imdbId='" + imdbId + '\'' +
                ", type='" + type + '\'' +
                ", writer='" + writer + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", ratings='" + ratings + '\'' +
                '}';
    }
}