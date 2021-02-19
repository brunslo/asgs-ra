package com.github.brunslo.asgsra.domain.coordinates;

import com.github.brunslo.asgsra.domain.coordinates.Coordinates.CoordinateSystem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordinatesForm {
    @NotNull
    @DecimalMin("-90")
    @DecimalMax("90")
    private Double latitude;

    @NotNull
    @DecimalMin("-180")
    @DecimalMax("180")
    private Double longitude;

    @NotNull
    private CoordinateSystem system;
}
