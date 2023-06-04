package com.movies.Movies.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.*;

import java.util.Collections;

@Configuration
public class ApiDocConfig {
    @Bean
    private OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Movie Thing!").description("This is a movie thing!").version("54.99"));
    }
}