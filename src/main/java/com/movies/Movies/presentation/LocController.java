package com.movies.Movies.presentation;

import com.movies.Movies.service.LocService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocController {

    private final LocService locService;

    public LocController(LocService locService) {
        this.locService = locService;
    }

    @GetMapping("/searchLocResults")
    @Operation(summary = "Searches for books matching the search term",
            description = "Response may include multiple Result values.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Result(s) found"),
            @ApiResponse(responseCode = "404", description = "Result(s) not found")
    })
    public String getResults(@RequestParam(value="q") String query){
        return locService.getResults(query);
    }

}
