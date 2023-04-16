package com.vitalis.backend.services;

import com.vitalis.backend.entities.HealthEvent;
import com.vitalis.backend.repositories.HealthEventsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;


@Service
public class HealthEventService {
    private final HealthEventsRepository healthEventsRepository;

    public HealthEventService(HealthEventsRepository healthEventsRepository) {
        this.healthEventsRepository = healthEventsRepository;
    }

    public ResponseEntity<?> getTodaysEvent() {
        Date todayDate = getCurrentDate();
        HealthEvent todaysEvent = healthEventsRepository.findByDate(todayDate);
        if (todaysEvent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(todaysEvent);
    }

    private Date getCurrentDate() {
        return Date.valueOf(LocalDate.now());
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
