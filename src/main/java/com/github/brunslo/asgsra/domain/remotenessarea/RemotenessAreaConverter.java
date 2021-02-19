package com.github.brunslo.asgsra.domain.remotenessarea;

import javax.persistence.AttributeConverter;

public class RemotenessAreaConverter implements AttributeConverter<RemotenessArea, String> {
    @Override
    public String convertToDatabaseColumn(RemotenessArea remotenessArea) {
        return remotenessArea == null ? null : String.valueOf(remotenessArea.code());
    }

    @Override
    public RemotenessArea convertToEntityAttribute(String code) {
        return code == null ? null : RemotenessArea.valueOf(Integer.parseInt(code));
    }
}
