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
    void getHealthBits() {
        // Arrange
        PageRequest pageRequest = PageRequest.of(0, 10);
        List<HealthBit> healthBits = List.of(
                new HealthBit(1L, "Fitness", "How to stay fit", "https://images.unsplash.com/photo-1604480132736-44c188fe4d20?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=990&q=80"),
                new HealthBit(2L, "Nutrition", "How to eat healthy", "https://images.unsplash.com/photo-1604480132736-44c188fe4d20?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=990&q=80")
        );
        Page<HealthBit> healthBitPage = new PageImpl<>(healthBits, pageRequest, 2);
        when(healthBitService.getAllHealthBits(pageRequest)).thenReturn(healthBitPage);

        // Act
        ResponseEntity<Page<HealthBit>> response = healthBitController.getHealthBits(0, 10,null);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(healthBitPage, response.getBody());
    }


    @Test
    void createHealthBit() {
        // Arrange
        HealthBit healthBit = new HealthBit(null, "Mental Health", "How to cope with stress", "https://images.unsplash.com/photo-1604480132736-44c188fe4d20?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=990&q=80");
        HealthBit createdHealthBit = new HealthBit(4L, "Mental Health", "How to cope with stress", "https://images.unsplash.com/photo-1604480132736-44c188fe4d20?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=990&q=80");
        when(healthBitService.createHealthBit(healthBit)).thenReturn(createdHealthBit);

        // Act
        ResponseEntity<HealthBit> response = healthBitController.createHealthBit(healthBit);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdHealthBit, response.getBody());
    }
}