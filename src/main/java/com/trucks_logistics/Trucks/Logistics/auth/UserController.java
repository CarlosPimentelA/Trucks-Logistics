package com.trucks_logistics.Trucks.Logistics.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }
}
