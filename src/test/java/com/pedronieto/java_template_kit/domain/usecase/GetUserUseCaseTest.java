package com.pedronieto.java_template_kit.domain.usecase;

import com.pedronieto.java_template_kit.adapter.input.user.dto.UserResponse;
import com.pedronieto.java_template_kit.domain.exception.BusinessException;
import com.pedronieto.java_template_kit.domain.mapper.UserMapper;
import com.pedronieto.java_template_kit.domain.model.User;
import com.pedronieto.java_template_kit.port.output.UserOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUserUseCaseTest {

    @Mock
    private UserOutputPort userOutputPort;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private GetUserUseCase getUserUseCase;

    @Test
    void givenExistingUserId_whenGetUserById_shouldReturnUserResponse() {
        String userId = "1";
        User user = new User(userId, "John Doe", "john.doe@example.com");
        UserResponse expectedResponse = new UserResponse(userId, "John Doe", "john.doe@example.com");

        when(userOutputPort.findById(userId)).thenReturn(Optional.of(user));
        when(userMapper.toResponse(any(User.class))).thenReturn(expectedResponse);

        UserResponse actualResponse = getUserUseCase.getUserById(userId);

        assertNotNull(actualResponse);
        assertEquals(expectedResponse.id(), actualResponse.id());
        verify(userOutputPort).findById(userId);
        verify(userMapper).toResponse(user);
    }

    @Test
    void givenNonExistingUserId_whenGetUserById_shouldThrowBusinessException() {
        String userId = "99";
        given(userOutputPort.findById(userId)).willReturn(Optional.empty());

        BusinessException exception = assertThrows(BusinessException.class, () -> {
            getUserUseCase.getUserById(userId);
        });

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals("User with id " + userId + " was not found.", exception.getMessage());
    }
}