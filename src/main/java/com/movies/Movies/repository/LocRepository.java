package com.movies.Movies.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class LocRepository {
    private final WebClient webClient;
    private static final String baseUrl = "https://api.themoviedb.org/3/search/movie";

    public LocRepository() {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }

    public String getResults(String query){

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("language", "en-US")
                        .queryParam("api_key", "ccb1d2d267cfb02bf8df578ecca952cb")
                        .queryParam("query", query)
                        .build()
                )
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }

}
