package com.onlinebooking.TicketBooking.service;

import com.onlinebooking.TicketBooking.entity.Event;
import com.onlinebooking.TicketBooking.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Integer id) {
        return eventRepository.findById(id);
    }

    public Event updateEvent(Integer id, Event updatedEvent) {
        return eventRepository.findById(id).map(event -> {
            event.setTitle(updatedEvent.getTitle());
            event.setPosterUrl(updatedEvent.getPosterUrl());
            event.setDateTime(updatedEvent.getDateTime());
            event.setRuntime(updatedEvent.getRuntime());
            event.setLanguages(updatedEvent.getLanguages());
            event.setGenre(updatedEvent.getGenre());
            event.setLocation(updatedEvent.getLocation());
            event.setArtistName(updatedEvent.getArtistName());
            event.setArtistPhotoUrl(updatedEvent.getArtistPhotoUrl());
            return eventRepository.save(event);
        }).orElseThrow(() -> new RuntimeException("Event not found with ID: " + id));
    }

    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }
}
