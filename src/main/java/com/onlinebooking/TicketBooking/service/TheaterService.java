package com.onlinebooking.TicketBooking.service;

import com.onlinebooking.TicketBooking.entity.Theater;
import com.onlinebooking.TicketBooking.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    // Get all theaters
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    // Get a theater by ID
    public Theater getTheaterById(Long id) {
        Optional<Theater> theater = theaterRepository.findById(id);
        return theater.orElse(null);
    }

    // Create a new theater
    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    // Delete a theater by ID
    public boolean deleteTheater(Long id) {
        if (theaterRepository.existsById(id)) {
            theaterRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
