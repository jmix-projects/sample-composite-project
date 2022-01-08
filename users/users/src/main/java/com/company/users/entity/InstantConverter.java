package com.company.users.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;

@Converter(autoApply = true)
public class InstantConverter implements AttributeConverter<Instant, Long> {

    @Override
    public Long convertToDatabaseColumn(final Instant anAttribute) {
        return anAttribute == null ? null : anAttribute.toEpochMilli();
    }

    @Override
    public Instant convertToEntityAttribute(final Long someDBData) {
        return someDBData == null ? null : Instant.ofEpochMilli(someDBData.longValue());
    }
}
