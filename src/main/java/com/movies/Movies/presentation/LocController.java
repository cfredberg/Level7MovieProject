package com.movies.Movies.presentation;

import com.movies.Movies.dataTransferObjects.Result;
import com.movies.Movies.service.LocService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
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
    public List<Result> getResults(@RequestParam(value="q") String query){
        List<Result> results = locService.getResults(query);
        if(CollectionUtils.isEmpty(results)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Result(s) not found.");
        }

        return results;
    }

}
