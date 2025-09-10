package com.pedronieto.java_template_kit.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "swagger")
public record SwaggerProperties(
        String title,
        String description,
        String version,
        String termsOfServiceUrl,
        String licenseName,
        String licenseUrl,
        Contact contact,
        List<Server> servers
) {
    public record Contact(String name, String url, String email) {}
    public record Server(String url, String description) {}
}