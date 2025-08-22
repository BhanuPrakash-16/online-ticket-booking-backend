package com.onlinebooking.TicketBooking.service;

import com.onlinebooking.TicketBooking.repository.MovieRepository;
import com.onlinebooking.TicketBooking.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieDao;

    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    public Optional<Movie> getMovieById(Integer id) {
        return movieDao.findById(id);
    }

    public Movie saveMovie(Movie movie) {
        return movieDao.save(movie);
    }

    public Movie updateMovie(Integer id, Movie movieDetails) {
        Movie movie = movieDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id " + id));
        movie.setTitle(movieDetails.getTitle());
        movie.setYear(movieDetails.getYear());
        movie.setRated(movieDetails.getRated());
        movie.setReleased(movieDetails.getReleased());
        movie.setRuntime(movieDetails.getRuntime());
        movie.setGenre(movieDetails.getGenre());
        movie.setDirector(movieDetails.getDirector());
        movie.setLanguages(movieDetails.getLanguages());
        movie.setPosterUrl(movieDetails.getPosterUrl());
        movie.setImdbRating(movieDetails.getImdbRating());
        movie.setImdbId(movieDetails.getImdbId());
        movie.setType(movieDetails.getType());
        movie.setWriter(movieDetails.getWriter());
        movie.setActors(movieDetails.getActors());
        movie.setPlot(movieDetails.getPlot());
        movie.setRatings(movieDetails.getRatings());
        return movieDao.save(movie);
    }

    public void deleteMovie(Integer id) {
        Movie movie = movieDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id " + id));
        movieDao.delete(movie);
    }
}