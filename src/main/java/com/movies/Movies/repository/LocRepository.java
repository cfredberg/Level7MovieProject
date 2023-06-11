package com.movies.Movies.repository;

import org.springframework.stereotype.Repository;

@Repository
public class LocRepository {

    public String getResults(String query){
        return "Searching for books related to " + query;
    }

}
