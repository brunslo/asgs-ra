package com.github.brunslo.asgsra.domain.coordinates;

import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class CoordinatesService {
    public Coordinates fromForm(@NonNull final CoordinatesForm form) {
        return new Coordinates(
                form.getLatitude(),
                form.getLongitude(),
                form.getSystem()
        );
    }

    public CoordinatesForm toForm(@NonNull final Coordinates coordinates) {
        return new CoordinatesForm(
                coordinates.latitude(),
                coordinates.longitude(),
                coordinates.system()
        );
    }
}
