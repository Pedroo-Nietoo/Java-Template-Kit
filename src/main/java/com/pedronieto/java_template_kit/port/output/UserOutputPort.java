package com.pedronieto.java_template_kit.port.output;

import com.pedronieto.java_template_kit.domain.model.User;

import java.util.Optional;

public interface UserOutputPort {
    Optional<User> findById(String id);
}
