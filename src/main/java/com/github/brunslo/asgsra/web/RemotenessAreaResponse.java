package com.github.brunslo.asgsra.web;

import com.github.brunslo.asgsra.domain.coordinates.Coordinates;
import com.github.brunslo.asgsra.domain.remotenessarea.RemotenessArea;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class RemotenessAreaResponse {
    @NonNull
    private Coordinates coordinates;

    @NonNull
    private RemotenessArea remotenessArea;
}
