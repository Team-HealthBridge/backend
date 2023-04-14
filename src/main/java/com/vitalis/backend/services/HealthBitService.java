package com.vitalis.backend.services;

import com.vitalis.backend.entities.HealthBit;
import com.vitalis.backend.repositories.HealthBitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<String> getHealthBitCategories() {
        return healthBitRepository.findDistinctCategories();
    }

    public Page<HealthBit> getRandomHealthBits(Pageable pageRequest) {
        return healthBitRepository.findRandom(pageRequest);
    }

    public Page<HealthBit> getRandomHealthBitsByCategory(String category, Pageable pageRequest) {
        return healthBitRepository.findRandomByCategory(category, pageRequest);
    }

    public void deleteHealthBit(HealthBit healthBit) {
        healthBitRepository.delete(healthBit);
    }
}
