package com.vitalis.backend.services;

import com.vitalis.backend.entities.HealthEvent;
import com.vitalis.backend.repositories.HealthEventsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HealthEventService {
    private final HealthEventsRepository healthEventsRepository;

    public HealthEventService(HealthEventsRepository healthEventsRepository) {
        this.healthEventsRepository = healthEventsRepository;
    }

    public ResponseEntity<?> getTodaysEvent() {
        String todayString = getTodaysFormattedDate();
        HealthEvent todaysEvent = healthEventsRepository.findByDate(todayString);
        if (todaysEvent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(todaysEvent);
    }

    private String getTodaysFormattedDate() {
        LocalDate today = LocalDate.now();
        String[] date = today.toString().split("-");
        return date[2] + "/" + date[1] + "/" + date[0];
    }

    public ResponseEntity<HealthEvent> createHealthEvent(HealthEvent healthEvent) {
        return ResponseEntity.ok(healthEventsRepository.save(healthEvent));
    }

    public ResponseEntity<?> deleteHealthEvent(Long id) {
        healthEventsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Page<HealthEvent>> getAllHealthEvents(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(healthEventsRepository.findAll(pageRequest));
    }
}
