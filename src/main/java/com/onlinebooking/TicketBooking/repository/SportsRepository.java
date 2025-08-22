package com.onlinebooking.TicketBooking.repository;

import com.onlinebooking.TicketBooking.entity.Sports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsRepository extends JpaRepository<Sports, Integer> {
}
