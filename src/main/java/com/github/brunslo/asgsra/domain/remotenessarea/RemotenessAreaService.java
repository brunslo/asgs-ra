package com.github.brunslo.asgsra.domain.remotenessarea;

import com.github.brunslo.asgsra.domain.coordinates.Coordinates;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RemotenessAreaService {
    @NonNull
    private final RemotenessAreaRepository repository;

    public Optional<RemotenessArea> findRemotenessArea(@NonNull final Coordinates coordinates) {
        val coordinate = new Coordinate(coordinates.longitude(), coordinates.latitude());

        val geometry = new GeometryFactory().createPoint(coordinate);
        geometry.setSRID(coordinates.system().getSrid());

        return repository.find(geometry)
                .map(RemotenessAreaEntity::getRemotenessArea);
    }
}
