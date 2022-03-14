package com.mot.onlineshop.payment.infrastructure.persistence.memory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRepositoryTest {

    @InjectMocks
    private InMemoryRepository inMemoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getOrder() {
        assertNotNull(inMemoryRepository.getOrder(UUID.randomUUID().toString()));
    }

    @Test
    void getPayer() {
        assertNotNull(inMemoryRepository.getPerson("2"));
    }

    @Test
    void getCreditCard() {
        assertNotNull(inMemoryRepository.getCreditCard("4"));
    }

    @Test
    void getConfig() {
        assertNotNull(inMemoryRepository.getConfig("PayU"));
    }
}