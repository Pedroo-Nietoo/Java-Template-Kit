package com.pedronieto.java_template_kit.adapter.output.persistence;

import com.pedronieto.java_template_kit.domain.model.User;
import com.pedronieto.java_template_kit.port.output.UserOutputPort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// @Repository marks this as a data access component.
// This is an in-memory implementation for demonstration purposes.
@Repository
public class InMemoryUserAdapter implements UserOutputPort {

    private final Map<String, User> userDatabase = new HashMap<>();

    public InMemoryUserAdapter() {
        userDatabase.put("1", new User("1", "John Doe", "john.doe@example.com"));
        userDatabase.put("2", new User("2", "Spring Boot", "spring.boot@example.com"));
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userDatabase.get(id));
    }
}