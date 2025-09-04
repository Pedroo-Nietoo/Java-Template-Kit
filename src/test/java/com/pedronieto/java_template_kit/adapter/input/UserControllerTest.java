package com.pedronieto.java_template_kit.adapter.input;

import com.pedronieto.java_template_kit.adapter.input.user.UserController;
import com.pedronieto.java_template_kit.adapter.input.user.dto.UserResponse;
import com.pedronieto.java_template_kit.port.input.UserInputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserInputPort userInputPort;

    @InjectMocks
    private UserController userController;

    private UserResponse mockUser;

    @BeforeEach
    void setUp() {
        mockUser = new UserResponse("123", "Pedro", "pedro@example.com");
    }

    @Test
    void getUserById_shouldReturnUserResponse() {
        String userId = "123";
        when(userInputPort.getUserById(userId)).thenReturn(mockUser);

        ResponseEntity<UserResponse> responseEntity = userController.getUserById(userId);

        assertEquals(200, responseEntity.getStatusCode().value());
        assertEquals(mockUser, responseEntity.getBody());

        verify(userInputPort, times(1)).getUserById(userId);
    }

    @Test
    void getUserById_shouldReturnNotFoundWhenNull() {
        String userId = "999";
        when(userInputPort.getUserById(userId)).thenReturn(null);

        ResponseEntity<UserResponse> responseEntity = userController.getUserById(userId);

        assertEquals(200, responseEntity.getStatusCode().value());
        assertNull(responseEntity.getBody());

        verify(userInputPort, times(1)).getUserById(userId);
    }
}
