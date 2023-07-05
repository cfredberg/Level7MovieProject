package com.movies.Movies.service;

import com.movies.Movies.dataTransferObjects.Result;
import com.movies.Movies.repository.LocRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocService {

    public List<Result> getResults(String query){
        LocRepository locrepo = new LocRepository();
        return locrepo.getResults(query);
    }

}
