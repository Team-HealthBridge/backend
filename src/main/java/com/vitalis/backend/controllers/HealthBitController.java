package com.vitalis.backend.controllers;

import com.vitalis.backend.entities.HealthBit;
import com.vitalis.backend.services.HealthBitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/health-bits")
public class HealthBitController {

    private final HealthBitService healthBitService;

    public HealthBitController(HealthBitService healthBitService) {
        this.healthBitService = healthBitService;
    }

    @GetMapping
    public ResponseEntity<Page<HealthBit>> getAllHealthBits(@RequestParam(defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<HealthBit> healthBits = healthBitService.getAllHealthBits(pageRequest);
        return ResponseEntity.ok(healthBits);
    }

    @GetMapping("/{category}")
    public ResponseEntity<Page<HealthBit>> getHealthBitsByCategory(@PathVariable String category, @RequestParam(defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<HealthBit> healthBits = healthBitService.getHealthBitsByCategory(category, pageRequest);
        return ResponseEntity.ok(healthBits);
    }

    @PostMapping
    public ResponseEntity<HealthBit> createHealthBit(@RequestBody HealthBit healthBit) {
        HealthBit createdHealthBit = healthBitService.createHealthBit(healthBit);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHealthBit);
    }
}