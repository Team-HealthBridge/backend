package com.vitalis.backend.controllers;

import com.vitalis.backend.entities.HealthBit;
import com.vitalis.backend.services.HealthBitService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/health-bits")
public class HealthBitController {

    private final HealthBitService healthBitService;

    public HealthBitController(HealthBitService healthBitService) {
        this.healthBitService = healthBitService;
    }

    @GetMapping
    public ResponseEntity<Page<HealthBit>> getHealthBits(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String category
    ) {

        PageRequest pageRequest = PageRequest.of(page, size);

        if (category != null) {
            Page<HealthBit> healthBits = healthBitService.getHealthBitsByCategory(category, pageRequest);
            return ResponseEntity.ok(healthBits);
        }

        Page<HealthBit> healthBits = healthBitService.getAllHealthBits(pageRequest);
        return ResponseEntity.ok(healthBits);
    }

    @GetMapping("/random")
    public ResponseEntity<Page<HealthBit>> getRandomHealthBit(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String category
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);

        if (category != null) {
            Page<HealthBit> healthBits = healthBitService.getRandomHealthBitsByCategory(category, pageRequest);
            return ResponseEntity.ok(healthBits);
        }

        Page<HealthBit> healthBits = healthBitService.getRandomHealthBits(pageRequest);
        return ResponseEntity.ok(healthBits);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getHealthBitCategories() {
        List<String> categories = healthBitService.getHealthBitCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<HealthBit> createHealthBit(@Valid @RequestBody HealthBit healthBit) {
        HealthBit createdHealthBit = healthBitService.createHealthBit(healthBit);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHealthBit);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteHealthBit(@Valid @RequestBody HealthBit healthBit) {
        healthBitService.deleteHealthBit(healthBit);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
