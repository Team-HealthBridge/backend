package com.vitalis.backend.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthBitTest {

    private HealthBit healthBit;

    @BeforeEach
    void setUp() {
        // create a sample HealthBit object for testing
        healthBit = new HealthBit();
        healthBit.setId(1L);
        healthBit.setCategory("Fitness");
        healthBit.setDescription("Some tips on how to stay fit and healthy.");
        healthBit.setPictureUrl("https://images.unsplash.com/photo-1604480132736-44c188fe4d20?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=990&q=80");
    }

    @Test
    void testGetId() {
        // test the getId method
        assertEquals(1L, healthBit.getId());
    }

    @Test
    void testSetId() {
        // test the setId method
        healthBit.setId(2L);
        assertEquals(2L, healthBit.getId());
    }

    @Test
    void testGetCategory() {
        // test the getCategory method
        assertEquals("Fitness", healthBit.getCategory());
    }

    @Test
    void testSetCategory() {
        // test the setCategory method
        healthBit.setCategory("Nutrition");
        assertEquals("Nutrition", healthBit.getCategory());
    }

    @Test
    void testGetDescription() {
        // test the getDescription method
        assertEquals("Some tips on how to stay fit and healthy.", healthBit.getDescription());
    }

    @Test
    void testSetDescription() {
        // test the setDescription method
        healthBit.setDescription("Some advice on what to eat and drink.");
        assertEquals("Some advice on what to eat and drink.", healthBit.getDescription());
    }

    @Test
    void testGetPicture() {
        // test the getPicture method
        assertEquals("https://images.unsplash.com/photo-1604480132736-44c188fe4d20?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=990&q=80", healthBit.getPictureUrl());
    }

    @Test
    void testSetPicture() {
        // test the setPicture method
        healthBit.setPictureUrl("https://images.unsplash.com/photo-1604480132736-44c188fe4d20?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=990&q=80");
        assertEquals("https://images.unsplash.com/photo-1604480132736-44c188fe4d20?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=990&q=80", healthBit.getPictureUrl());
    }
}