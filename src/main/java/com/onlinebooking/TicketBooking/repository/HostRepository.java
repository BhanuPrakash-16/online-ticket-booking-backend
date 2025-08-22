package com.onlinebooking.TicketBooking.repository;

import com.onlinebooking.TicketBooking.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HostRepository extends JpaRepository<Host, Long> {
    Optional<Host> findByEmail(String email);
}
