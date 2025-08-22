package com.onlinebooking.TicketBooking.controller;

import com.onlinebooking.TicketBooking.entity.Sports;
import com.onlinebooking.TicketBooking.service.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sports")
public class SportsController {

    @Autowired
    private SportsService sportsService;

    @PostMapping
    public ResponseEntity<Sports> createSports(@Valid @RequestBody Sports sports) {
        return ResponseEntity.ok(sportsService.createSports(sports));
    }

    @GetMapping
    public ResponseEntity<List<Sports>> getAllSports() {
        return ResponseEntity.ok(sportsService.getAllSports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sports> getSportsById(@PathVariable Integer id) {
        return sportsService.getSportsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sports> updateSports(@PathVariable Integer id, @Valid @RequestBody Sports sports) {
        return ResponseEntity.ok(sportsService.updateSports(id, sports));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSports(@PathVariable Integer id) {
        sportsService.deleteSports(id);
        return ResponseEntity.noContent().build();
    }
}
