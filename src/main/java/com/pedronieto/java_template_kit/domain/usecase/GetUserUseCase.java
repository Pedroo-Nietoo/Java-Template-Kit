package com.pedronieto.java_template_kit.domain.usecase;

import com.pedronieto.java_template_kit.adapter.input.user.dto.UserResponse;
import com.pedronieto.java_template_kit.domain.exception.BusinessException;
import com.pedronieto.java_template_kit.domain.mapper.UserMapper;
import com.pedronieto.java_template_kit.port.input.UserInputPort;
import com.pedronieto.java_template_kit.port.output.UserOutputPort;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class GetUserUseCase implements UserInputPort {

    private final UserOutputPort userOutputPort;
    private final UserMapper userMapper;

    public GetUserUseCase(UserOutputPort userOutputPort, UserMapper userMapper) {
        this.userOutputPort = userOutputPort;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse getUserById(String id) {
        return userOutputPort.findById(id)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new BusinessException(NOT_FOUND, "User with id " + id + " was not found."));
    }
}
