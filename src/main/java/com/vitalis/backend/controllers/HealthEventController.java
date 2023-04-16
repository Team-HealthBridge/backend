package com.vitalis.backend.controllers;

import com.vitalis.backend.entities.HealthEvent;
import com.vitalis.backend.services.HealthEventService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/health-events")
public class HealthEventController {
    private final HealthEventService healthEventService;

    public HealthEventController(HealthEventService healthEventService) {
        this.healthEventService = healthEventService;
    }

    @GetMapping
    public ResponseEntity<?> getTodaysEvent() {
        return healthEventService.getTodaysEvent();
    }

    @GetMapping("/all")
    public ResponseEntity<Page<HealthEvent>> getAllHealthEvents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return healthEventService.getAllHealthEvents(page, size);
    }

    @PostMapping
    public ResponseEntity<HealthEvent> createHealthEvent(@Valid @RequestBody HealthEvent healthEvent) {
        return healthEventService.createHealthEvent(healthEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHealthEvent(@PathVariable Long id) {
        return healthEventService.deleteHealthEvent(id);
    }

}
