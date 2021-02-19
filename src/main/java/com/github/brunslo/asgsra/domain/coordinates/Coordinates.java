package com.github.brunslo.asgsra.domain.coordinates;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;

public record Coordinates(double latitude, double longitude, CoordinateSystem system) {
    public Coordinates {
        Assert.notNull(system, "system must not be null");
    }

    @RequiredArgsConstructor
    public enum CoordinateSystem {
        GDA94(4283),
        WGS84(4326);

        @Getter
        private final int srid;
    }
}