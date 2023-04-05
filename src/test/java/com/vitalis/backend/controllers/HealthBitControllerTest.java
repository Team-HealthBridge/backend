package com.vitalis.backend.controllers;

import com.vitalis.backend.entities.HealthBit;
import com.vitalis.backend.services.HealthBitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class HealthBitControllerTest {

    @Mock
    private HealthBitService healthBitService;

    @InjectMocks
    private HealthBitController healthBitController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllHealthBits() {
        // Arrange
        PageRequest pageRequest = PageRequest.of(0, 10);
        List<HealthBit> healthBits = List.of(
                new HealthBit(1L, "Fitness", "How to stay fit", new byte[]{1, 2, 3}),
                new HealthBit(2L, "Nutrition", "How to eat healthy", new byte[]{4, 5, 6})
        );
        Page<HealthBit> healthBitPage = new PageImpl<>(healthBits, pageRequest, 2);
        when(healthBitService.getAllHealthBits(pageRequest)).thenReturn(healthBitPage);

        // Act
        ResponseEntity<Page<HealthBit>> response = healthBitController.getAllHealthBits(0, 10);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(healthBitPage, response.getBody());
    }

    @Test
    void getHealthBitsByCategory() {
        // Arrange
        PageRequest pageRequest = PageRequest.of(0, 10);
        List<HealthBit> healthBits = List.of(
                new HealthBit(1L, "Fitness", "How to stay fit", new byte[]{1, 2, 3}),
                new HealthBit(3L, "Fitness", "How to lose weight", new byte[]{7, 8, 9})
        );
        Page<HealthBit> healthBitPage = new PageImpl<>(healthBits, pageRequest, 2);
        when(healthBitService.getHealthBitsByCategory("Fitness", pageRequest)).thenReturn(healthBitPage);

        // Act
        ResponseEntity<Page<HealthBit>> response = healthBitController.getHealthBitsByCategory("Fitness", 0);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(healthBitPage, response.getBody());
    }

    @Test
    void createHealthBit() {
        // Arrange
        HealthBit healthBit = new HealthBit(null, "Mental Health", "How to cope with stress", new byte[]{10, 11, 12});
        HealthBit createdHealthBit = new HealthBit(4L, "Mental Health", "How to cope with stress", new byte[]{10, 11, 12});
        when(healthBitService.createHealthBit(healthBit)).thenReturn(createdHealthBit);

        // Act
        ResponseEntity<HealthBit> response = healthBitController.createHealthBit(healthBit);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdHealthBit, response.getBody());
    }
}