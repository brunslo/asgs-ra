package com.github.brunslo.asgsra.domain.remotenessarea;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class RemotenessAreaSerializer extends JsonSerializer<RemotenessArea> {
    @Override
    public void serialize(final RemotenessArea ra,
                          final JsonGenerator generator,
                          final SerializerProvider provider) throws IOException {
        generator.writeStartObject();

        generator.writeNumberField("code", ra.code());

        generator.writeObjectFieldStart("state");
        generator.writeStringField("name", ra.state().name());
        generator.writeNumberField("code", ra.state().getCode());
        generator.writeEndObject();

        generator.writeObjectFieldStart("category");
        generator.writeStringField("name", ra.category().name());
        generator.writeNumberField("code", ra.category().getCode());
        generator.writeEndObject();

        generator.writeEndObject();
    }
}
