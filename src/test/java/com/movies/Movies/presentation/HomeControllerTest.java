package com.movies.Movies.presentation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HomeControllerTest {
    HomeController hc;
    @BeforeEach
    public void setup(){
        hc = new HomeController();
    }

    @Test
    public void whenHome_thenReturnRedirect(){
        //Given
        String expected = "redirect:swagger-ui.html";
        //When
        String actuall = hc.home();
        //Then
        assertEquals(expected, actuall);
    }
}
