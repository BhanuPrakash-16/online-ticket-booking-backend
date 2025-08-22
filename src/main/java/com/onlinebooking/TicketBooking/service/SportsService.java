package com.onlinebooking.TicketBooking.service;

import com.onlinebooking.TicketBooking.entity.Sports;
import com.onlinebooking.TicketBooking.repository.SportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportsService {

    @Autowired
    private SportsRepository sportsRepository;

    public Sports createSports(Sports sports) {
        return sportsRepository.save(sports);
    }

    public List<Sports> getAllSports() {
        return sportsRepository.findAll();
    }

    public Optional<Sports> getSportsById(Integer id) {
        return sportsRepository.findById(id);
    }

    public Sports updateSports(Integer id, Sports updatedSports) {
        return sportsRepository.findById(id).map(sports -> {
            sports.setTitle(updatedSports.getTitle());
            sports.setPosterUrl(updatedSports.getPosterUrl());
            sports.setDateTime(updatedSports.getDateTime());
            sports.setRuntime(updatedSports.getRuntime());
            sports.setLanguages(updatedSports.getLanguages());
            sports.setGenre(updatedSports.getGenre());
            sports.setLocation(updatedSports.getLocation());
            return sportsRepository.save(sports);
        }).orElseThrow(() -> new RuntimeException("Sports event not found with ID: " + id));
    }

    public void deleteSports(Integer id) {
        sportsRepository.deleteById(id);
    }
}
