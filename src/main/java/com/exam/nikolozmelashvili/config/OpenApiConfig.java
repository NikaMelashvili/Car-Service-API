package com.exam.nikolozmelashvili.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Car Services API")
                        .version("1.0")
                        .description("API documentation for Car Services application"));
    }

    @Bean
    public GroupedOpenApi publicApiServices() {
        return GroupedOpenApi.builder()
                .group("services")
                .pathsToMatch("/rest/services/**")
                .build();
    }

    @Bean
    public GroupedOpenApi publicApiCars() {
        return GroupedOpenApi.builder()
                .group("cars")
                .pathsToMatch("/rest/car/**")
                .build();
    }

    @Bean
    public GroupedOpenApi publicApiUser() {
        return GroupedOpenApi.builder()
                .group("users")
                .pathsToMatch("/rest/user/**")
                .build();
    }
}
