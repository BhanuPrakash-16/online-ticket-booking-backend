package com.onlinebooking.TicketBooking.controller;

import com.onlinebooking.TicketBooking.entity.Theater;
import com.onlinebooking.TicketBooking.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping
    public ResponseEntity<Theater> createTheater(@RequestBody Theater theater) {
        return new ResponseEntity<>(theaterService.createTheater(theater), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id) {
        return new ResponseEntity<>(theaterService.getTheaterById(id), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long id) {
        theaterService.deleteTheater(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
