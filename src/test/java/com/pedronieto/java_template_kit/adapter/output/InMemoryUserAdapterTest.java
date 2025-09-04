package com.pedronieto.java_template_kit.adapter.output;

import com.pedronieto.java_template_kit.adapter.output.persistence.InMemoryUserAdapter;
import com.pedronieto.java_template_kit.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryUserAdapterTest {

    private InMemoryUserAdapter inMemoryUserAdapter;

    @BeforeEach
    void setUp() {
        inMemoryUserAdapter = new InMemoryUserAdapter();
    }

    @Test
    void givenExistingId_whenFindById_shouldReturnUser() {
        Optional<User> result = inMemoryUserAdapter.findById("1");

        assertTrue(result.isPresent());
        assertEquals("1", result.get().getId());
        assertEquals("John Doe", result.get().getName());
        assertEquals("john.doe@example.com", result.get().getEmail());
    }

    @Test
    void givenAnotherExistingId_whenFindById_shouldReturnUser() {
        Optional<User> result = inMemoryUserAdapter.findById("2");

        assertTrue(result.isPresent());
        assertEquals("2", result.get().getId());
        assertEquals("Spring Boot", result.get().getName());
        assertEquals("spring.boot@example.com", result.get().getEmail());
    }

    @Test
    void givenNonExistingId_whenFindById_shouldReturnEmpty() {
        Optional<User> result = inMemoryUserAdapter.findById("99");

        assertFalse(result.isPresent());
    }
}