package com.movies.Movies.presentation;

import com.movies.Movies.dataTransferObjects.Result;
import com.movies.Movies.service.LocService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LocController.class)
public class LocControllerIntTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocService locService;

    @Test
    public void givenGoodQuery_whenSearchForResults_thenIsOkAndReturnsResults() throws Exception {
        //given
        String query = "Java";
        String title = "Java: A Drink, an Island, and a Programming Language";
        boolean adult = false;
        String overview = "Movie about java stuff";
        Result result = new Result();
        result.setTitle(title);
        result.setAdult(adult);
        result.setOverview(overview);
        List<Result> expectedResults = Collections.singletonList(result);

        when(locService.getResults(query)).thenReturn(expectedResults);

        //when
        //then
        MvcResult mvcResult = mockMvc.perform(get("/searchLocResults?q=" + query))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());

    }
}