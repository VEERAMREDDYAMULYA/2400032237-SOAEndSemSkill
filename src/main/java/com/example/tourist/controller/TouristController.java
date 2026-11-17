package com.example.tourist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tourist.entity.Tourist;
import com.example.tourist.repository.TouristRepository;
import com.example.tourist.security.TokenValidation;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {
    private final TouristRepository touristRepository;
    private final TokenValidation tokenValidation;

    public TouristController(TouristRepository touristRepository, TokenValidation tokenValidation) {
        this.touristRepository = touristRepository;
        this.tokenValidation = tokenValidation;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTourist(
            @PathVariable Long id,
            @RequestHeader(value = "token", required = false) String token,
            @RequestBody Tourist updatedTourist) {

        if (!tokenValidation.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or missing token");
        }

        Tourist tourist = touristRepository.findById(id).orElse(null);
        if (tourist == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tourist not found");
        }

        tourist.setName(updatedTourist.getName());
        tourist.setPlace(updatedTourist.getPlace());
        tourist.setEmail(updatedTourist.getEmail());
        touristRepository.save(tourist);

        return ResponseEntity.ok("Tourist updated successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tourist> getTourist(@PathVariable Long id) {
        return touristRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
