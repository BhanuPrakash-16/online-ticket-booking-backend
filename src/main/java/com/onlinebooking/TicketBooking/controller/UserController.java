package com.onlinebooking.TicketBooking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onlinebooking.TicketBooking.entity.User;
import com.onlinebooking.TicketBooking.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/send-otp")
    public ResponseEntity<User> sendOtp(@RequestBody User user) {
        User newUser = userService.sendOtpForRegistration(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody OtpRequest request) {
        boolean verified = userService.verifyOtp(request.getEmail(), request.getOtp());
        if (verified) {
            return ResponseEntity.ok("OTP verified successfully");
        }
        return ResponseEntity.badRequest().body("Invalid OTP");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (user != null && user.isVerified()) {
            return ResponseEntity.ok(user); // Return full User object with role
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
    
    
    @GetMapping("/account/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/account/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

class OtpRequest {
    private String email;
    private String otp;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }
}

class LoginRequest {
    private String email;
    private String password;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
