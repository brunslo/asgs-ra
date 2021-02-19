package com.github.brunslo.asgsra.domain.remotenessarea;

import org.locationtech.jts.geom.Geometry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RemotenessAreaRepository extends org.springframework.data.repository.Repository<RemotenessAreaEntity, Geometry> {
    @Query(value = """
            SELECT primaryindex, ra_code_2016 
            FROM ra_2016_aust ra 
            WHERE st_covers(ra.geom, st_setsrid(:geometry, 4283))""",
            nativeQuery = true)
    Optional<RemotenessAreaEntity> find(@Param("geometry") Geometry geometry);
}
