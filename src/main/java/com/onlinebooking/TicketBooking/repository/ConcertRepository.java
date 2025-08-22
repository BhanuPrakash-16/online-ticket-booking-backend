package com.onlinebooking.TicketBooking.repository;

import com.onlinebooking.TicketBooking.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Integer> {
}
