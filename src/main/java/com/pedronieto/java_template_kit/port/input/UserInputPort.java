package com.pedronieto.java_template_kit.port.input;

import com.pedronieto.java_template_kit.adapter.input.user.dto.UserResponse;

public interface UserInputPort {
    UserResponse getUserById(String id);
}
