package com.github.brunslo.asgsra.web;

import com.github.brunslo.asgsra.domain.coordinates.CoordinatesForm;
import com.github.brunslo.asgsra.domain.coordinates.CoordinatesService;
import com.github.brunslo.asgsra.domain.remotenessarea.RemotenessAreaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MainController {
    @NonNull
    private final CoordinatesService coordinatesService;

    @NonNull
    private final RemotenessAreaService remotenessAreaService;

    @GetMapping(value = "/remoteness-area")
    public ResponseEntity<RemotenessAreaResponse> getRemotenessArea(@Valid final CoordinatesForm coordinatesForm) {
        val coordinates = coordinatesService.fromForm(coordinatesForm);

        return remotenessAreaService.findRemotenessArea(coordinates)
                .map(x -> new RemotenessAreaResponse(coordinates, x))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "coordinates not found within ASGS-RA database"));
    }
}
