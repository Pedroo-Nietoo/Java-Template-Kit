package com.pedronieto.java_template_kit.adapter.input.user;

import com.pedronieto.java_template_kit.adapter.input.user.dto.UserResponse;
import com.pedronieto.java_template_kit.port.input.UserInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController implements SwaggerUserController {

    private final UserInputPort userInputPort;

    public UserController(UserInputPort userInputPort) {
        this.userInputPort = userInputPort;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") String id) {
        UserResponse response = userInputPort.getUserById(id);
        return ResponseEntity.ok(response);
    }
}