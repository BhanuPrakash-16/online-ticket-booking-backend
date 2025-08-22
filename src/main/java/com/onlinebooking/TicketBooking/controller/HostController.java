package com.onlinebooking.TicketBooking.controller;

import com.onlinebooking.TicketBooking.entity.Host;
import com.onlinebooking.TicketBooking.service.HostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/host-auth")
@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class HostController {

    @Autowired
    private HostService hostService;

    @PostMapping("/send-otp")
    public ResponseEntity<Host> sendOtp(@RequestBody Host host) {
        Host newHost = hostService.sendOtpForRegistration(host);
        return ResponseEntity.ok(newHost);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody HostOtpRequest request) {
        boolean verified = hostService.verifyOtp(request.getEmail(), request.getOtp());
        if (verified) {
            return ResponseEntity.ok("OTP verified successfully");
        }
        return ResponseEntity.badRequest().body("Invalid OTP");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody HostLoginRequest loginRequest) {
        Host host = hostService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (host != null && host.isVerified()) {
            return ResponseEntity.ok(host);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Host> getHostById(@PathVariable Long id) {
        Host host = hostService.getHostById(id)
                .orElseThrow(() -> new RuntimeException("Host not found"));
        return ResponseEntity.ok(host);
    }

    @PutMapping("/account/{id}")
    public ResponseEntity<Host> updateHost(@PathVariable Long id, @RequestBody Host hostDetails) {
        Host updatedHost = hostService.updateHost(id, hostDetails);
        return ResponseEntity.ok(updatedHost);
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<Void> deleteHost(@PathVariable Long id) {
        hostService.deleteHost(id);
        return ResponseEntity.noContent().build();
    }
}

class HostOtpRequest {
    private String email;
    private String otp;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }
}

class HostLoginRequest {
    private String email;
    private String password;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
