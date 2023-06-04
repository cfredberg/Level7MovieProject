package com.movies.Movies.presentation;

import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocController {

    @GetMapping("/searchLocResults")
    @ApiOperation(value = "Searches for books matching the search term",
            notes = "Response may include multiple Result values.",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Result(s) found")
    })
    public String getResults(@RequestParam(value="q") String query){
        return "Hello, world!";
    }

}
