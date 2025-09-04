package com.pedronieto.java_template_kit.domain.mapper;

import com.pedronieto.java_template_kit.adapter.input.user.dto.UserResponse;
import com.pedronieto.java_template_kit.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        if (user == null) {
            return null;
        }
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}