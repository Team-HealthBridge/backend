package com.vitalis.backend.services;

import com.vitalis.backend.entities.HealthBit;
import com.vitalis.backend.repositories.HealthBitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HealthBitService {

    private final HealthBitRepository healthBitRepository;

    public HealthBitService(HealthBitRepository healthBitRepository) {
        this.healthBitRepository = healthBitRepository;
    }

    public Page<HealthBit> getAllHealthBits(Pageable pageable) {
        return healthBitRepository.findAll(pageable);
    }

    public Page<HealthBit> getHealthBitsByCategory(String category, Pageable pageable) {
        return healthBitRepository.findByCategory(category, pageable);
    }

    public HealthBit createHealthBit(HealthBit healthBit) {
        return healthBitRepository.save(healthBit);
    }
}
