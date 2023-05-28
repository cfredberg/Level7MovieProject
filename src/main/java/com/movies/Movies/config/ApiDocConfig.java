package com.movies.Movies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.*;

import java.util.Collections;

@Configuration
@EnableSwagger3
public class ApiDocConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Level 7 Cheetah Search",
                "League of Amazing Programmers Level 7 Cheetah Search",
                "1.0.0",
                null,
                new Contact("Matt Freedman", "www.jointheleague.org", "matt.freedman@jointheleague.org"),
                null, null, Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
}