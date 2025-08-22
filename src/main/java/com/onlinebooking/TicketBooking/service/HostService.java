package com.onlinebooking.TicketBooking.service;

import com.onlinebooking.TicketBooking.entity.Host;
import com.onlinebooking.TicketBooking.repository.HostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class HostService {

    @Autowired
    private HostRepository hostRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Host sendOtpForRegistration(Host host) {
        Optional<Host> existingHost = hostRepository.findByEmail(host.getEmail());
        if (existingHost.isPresent()) {
            throw new RuntimeException("Email already registered");
        }
        String otp = String.format("%06d", new Random().nextInt(999999));
        host.setOtp(otp);
        host.setVerified(false);
        Host savedHost = hostRepository.save(host);
        sendOtpEmail(host.getEmail(), otp);
        return savedHost;
    }

    public boolean verifyOtp(String email, String otp) {
        Optional<Host> hostOpt = hostRepository.findByEmail(email);
        if (hostOpt.isPresent()) {
            Host host = hostOpt.get();
            if (host.getOtp() != null && host.getOtp().equals(otp)) {
                host.setVerified(true);
                host.setOtp(null);
                hostRepository.save(host);
                return true;
            }
        }
        return false;
    }

    private void sendOtpEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp + "\nValid for 10 minutes.");
        mailSender.send(message);
    }

    public Host login(String email, String password) {
        Optional<Host> host = hostRepository.findByEmail(email);
        if (host.isPresent() && host.get().getPassword().equals(password) && host.get().isVerified()) {
            return host.get();
        }
        return null;
    }

    public Optional<Host> getHostById(Long id) {
        return hostRepository.findById(id);
    }

    public Host updateHost(Long id, Host hostDetails) {
        Host host = hostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Host not found"));
        host.setFullName(hostDetails.getFullName());
        host.setEmail(hostDetails.getEmail());
        host.setPassword(hostDetails.getPassword());
        return hostRepository.save(host);
    }

    public void deleteHost(Long id) {
        Host host = hostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Host not found"));
        hostRepository.delete(host);
    }
}
