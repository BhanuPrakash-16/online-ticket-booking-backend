package com.onlinebooking.TicketBooking.repository;

import com.onlinebooking.TicketBooking.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    // You can define custom query methods here if needed in the future
}
