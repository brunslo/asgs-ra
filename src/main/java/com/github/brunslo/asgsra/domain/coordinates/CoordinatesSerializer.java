package com.github.brunslo.asgsra.domain.coordinates;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class CoordinatesSerializer extends JsonSerializer<Coordinates> {
    @Override
    public void serialize(final Coordinates coordinates,
                          final JsonGenerator generator,
                          final SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeNumberField("latitude", coordinates.latitude());
        generator.writeNumberField("longitude", coordinates.longitude());

        generator.writeObjectFieldStart("system");
        generator.writeStringField("name", coordinates.system().name());
        generator.writeNumberField("srid", coordinates.system().getSrid());
        generator.writeEndObject();

        generator.writeEndObject();
    }
}
