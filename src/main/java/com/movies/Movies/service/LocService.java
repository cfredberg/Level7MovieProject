package com.movies.Movies.service;

import com.movies.Movies.repository.LocRepository;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.spi.LocaleNameProvider;

@Service
public class LocService {

    public String getResults(String query){
        LocRepository locrepo = new LocRepository();
        return locrepo.getResults(query);
    }

}
