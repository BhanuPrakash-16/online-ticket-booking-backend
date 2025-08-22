package com.onlinebooking.TicketBooking.repository;

import com.onlinebooking.TicketBooking.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
