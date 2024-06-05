package dev.example.rest_client.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Leonardo San Blas",
                        email = "leonardosanblas@gmail.com",
                        url = "http://www.linkedin.com/in/leonardo-san-blas-sanchez-213405286"
                ),
                description = "OpenApi documentation for rest client examples",
                title = "OpenApi specification",
                version = "1.0",
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {
}
