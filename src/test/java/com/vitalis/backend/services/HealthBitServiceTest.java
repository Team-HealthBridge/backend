package com.vitalis.backend.services;

import com.vitalis.backend.entities.HealthBit;
import com.vitalis.backend.repositories.HealthBitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HealthBitServiceTest {

    @Mock
    private HealthBitRepository healthBitRepository;

    private HealthBitService healthBitService;

    @BeforeEach
    void setUp() throws Exception {
        // initialize the mock objects using openMocks
        try (AutoCloseable ignored = MockitoAnnotations.openMocks(this)) {
            // create the service to test
            healthBitService = new HealthBitService(healthBitRepository);
        }
    }

    @Test
    void testGetAllHealthBits() {
        // create a sample pageable object
        PageRequest pageable = PageRequest.of(0, 10);

        // create a sample list of HealthBit objects
        List<HealthBit> healthBits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            HealthBit healthBit = new HealthBit();
            healthBit.setId((long) i);
            healthBit.setCategory("Fitness");
            healthBit.setDescription("Some tips on how to stay fit and healthy.");
            healthBit.setPicture(new byte[]{1, 2, 3});
            healthBits.add(healthBit);
        }

        // create a sample page of HealthBit objects
        Page<HealthBit> healthBitPage = new PageImpl<>(healthBits);

        // mock the repository method to return the sample page
        when(healthBitRepository.findAll(pageable)).thenReturn(healthBitPage);

        // test the service method
        Page<HealthBit> result = healthBitService.getAllHealthBits(pageable);
        assertEquals(healthBitPage, result);
        verify(healthBitRepository, times(1)).findAll(pageable);
    }

    @Test
    void testGetHealthBitsByCategory() {
        // create a sample pageable object
        PageRequest pageable = PageRequest.of(0, 10);

        // create a sample list of HealthBit objects with the same category
        List<HealthBit> healthBits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            HealthBit healthBit = new HealthBit();
            healthBit.setId((long) i);
            healthBit.setCategory("Nutrition");
            healthBit.setDescription("Some advice on what to eat and drink.");
            healthBit.setPicture(new byte[]{4, 5, 6});
            healthBits.add(healthBit);
        }

        // create a sample page of HealthBit objects with the same category
        Page<HealthBit> healthBitPage = new PageImpl<>(healthBits);

        // mock the repository method to return the sample page
        when(healthBitRepository.findByCategory("Nutrition", pageable)).thenReturn(healthBitPage);

        // test the service method
        Page<HealthBit> result = healthBitService.getHealthBitsByCategory("Nutrition", pageable);
        assertEquals(healthBitPage, result);
        verify(healthBitRepository, times(1)).findByCategory("Nutrition", pageable);
    }

    @Test
    void testCreateHealthBit() {
        // create a sample HealthBit object to save
        HealthBit healthBit = new HealthBit();
        healthBit.setId(1L);
        healthBit.setCategory("Fitness");
        healthBit.setDescription("Some tips on how to stay fit and healthy.");
        healthBit.setPicture(new byte[]{1, 2, 3});

        // mock the repository method to return the same object
        when(healthBitRepository.save(healthBit)).thenReturn(healthBit);

        // test the service method
        HealthBit result = healthBitService.createHealthBit(healthBit);
        assertEquals(healthBit, result);
        verify(healthBitRepository, times(1)).save(healthBit);
    }
}