package com.pedronieto.java_template_kit.domain.mapper;

import com.pedronieto.java_template_kit.adapter.input.user.dto.UserResponse;
import com.pedronieto.java_template_kit.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        userMapper = new UserMapper();
    }

    @Test
    void givenValidUser_whenToResponse_thenCorrectlyMapsToUserResponse() {
        User user = new User("1", "Jane Doe", "jane.doe@example.com");

        UserResponse response = userMapper.toResponse(user);

        assertNotNull(response);
        assertEquals(user.getId(), response.id());
        assertEquals(user.getName(), response.name());
        assertEquals(user.getEmail(), response.email());
    }

    @Test
    void givenNullUser_whenToResponse_thenReturnsNull() {
        UserResponse response = userMapper.toResponse(null);

        assertNull(response);
    }
}