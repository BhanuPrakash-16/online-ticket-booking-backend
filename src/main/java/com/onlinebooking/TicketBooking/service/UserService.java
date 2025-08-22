package com.onlinebooking.TicketBooking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.onlinebooking.TicketBooking.entity.User;
import com.onlinebooking.TicketBooking.repository.UserRepository;

import java.util.Optional;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
     
    @Autowired
    private JavaMailSender mailSender;

    public User sendOtpForRegistration(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }
        String otp = String.format("%06d", new Random().nextInt(999999));
        user.setOtp(otp);
        user.setVerified(false);
        User savedUser = userRepository.save(user);
        sendOtpEmail(user.getEmail(), otp);
        return savedUser;
    }

    public boolean verifyOtp(String email, String otp) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getOtp() != null && user.getOtp().equals(otp)) {
                user.setVerified(true);
                user.setOtp(null);
                userRepository.save(user);
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

    public User login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password) && user.get().isVerified()) {
            return user.get();
        }
        return null;
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setFullName(userDetails.getFullName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
