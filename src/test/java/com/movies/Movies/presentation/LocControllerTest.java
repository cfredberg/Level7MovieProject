package com.movies.Movies.presentation;

import com.movies.Movies.dataTransferObjects.Result;
import com.movies.Movies.service.LocService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LocControllerTest {
    private LocController locController;

    @Mock
    private LocService locService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        locController = new LocController(locService);
    }

    @Test
    void givenGoodQuery_whenGetResults_thenReturnListOfResults() {
        //given
        String query = "Batman";
        Result result = new Result();
        result.setTitle("The One of Many Batmans");
        result.setOriginalTitle("The One and Only Batman");
        result.setPopularity(10.0);
        List<Result> expectedResults = Collections.singletonList(result);

        when(locService.getResults(query))
                .thenReturn(expectedResults);

        //when
        List<Result> actualResults = locController.getResults(query);

        //then
        assertEquals(expectedResults, actualResults);
    }
}
