package com.onlinebooking.TicketBooking.service;

import com.onlinebooking.TicketBooking.entity.Concert;
import com.onlinebooking.TicketBooking.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcertService {

    @Autowired
    private ConcertRepository concertRepository;

    public Concert createConcert(Concert concert) {
        return concertRepository.save(concert);
    }

    public List<Concert> getAllConcerts() {
        return concertRepository.findAll();
    }

    public Optional<Concert> getConcertById(Integer id) {
        return concertRepository.findById(id);
    }

    public Concert updateConcert(Integer id, Concert updatedConcert) {
        return concertRepository.findById(id).map(concert -> {
            concert.setTitle(updatedConcert.getTitle());
            concert.setPosterUrl(updatedConcert.getPosterUrl());
            concert.setDateTime(updatedConcert.getDateTime());
            concert.setRuntime(updatedConcert.getRuntime());
            concert.setLanguages(updatedConcert.getLanguages());
            concert.setGenre(updatedConcert.getGenre());
            concert.setLocation(updatedConcert.getLocation());
            concert.setArtistName(updatedConcert.getArtistName());
            concert.setArtistPhotoUrl(updatedConcert.getArtistPhotoUrl());
            return concertRepository.save(concert);
        }).orElseThrow(() -> new RuntimeException("Concert not found with ID: " + id));
    }

    public void deleteConcert(Integer id) {
        concertRepository.deleteById(id);
    }
}
