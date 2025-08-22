package com.onlinebooking.TicketBooking.controller;

import com.onlinebooking.TicketBooking.entity.Concert;
import com.onlinebooking.TicketBooking.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/concerts")
public class ConcertController {

    @Autowired
    private ConcertService concertService;

    @PostMapping
    public ResponseEntity<Concert> createConcert(@Valid @RequestBody Concert concert) {
        return ResponseEntity.ok(concertService.createConcert(concert));
    }

    @GetMapping
    public ResponseEntity<List<Concert>> getAllConcerts() {
        return ResponseEntity.ok(concertService.getAllConcerts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Concert> getConcertById(@PathVariable Integer id) {
        return concertService.getConcertById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Concert> updateConcert(@PathVariable Integer id, @Valid @RequestBody Concert concert) {
        return ResponseEntity.ok(concertService.updateConcert(id, concert));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConcert(@PathVariable Integer id) {
        concertService.deleteConcert(id);
        return ResponseEntity.noContent().build();
    }
}
