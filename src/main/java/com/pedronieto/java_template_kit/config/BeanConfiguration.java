package com.pedronieto.java_template_kit.config;

import com.pedronieto.java_template_kit.domain.mapper.UserMapper;
import com.pedronieto.java_template_kit.domain.usecase.GetUserUseCase;
import com.pedronieto.java_template_kit.port.input.UserInputPort;
import com.pedronieto.java_template_kit.port.output.UserOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserInputPort getUserUseCase(UserOutputPort userOutputPort, UserMapper userMapper) {
        return new GetUserUseCase(userOutputPort, userMapper);
    }
}