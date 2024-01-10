package com.karadyauran.agile.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.UUID;


@Converter(autoApply = true)
public class UUIDAttributeConverter implements AttributeConverter<UUID, String> {
    @Override
    public String convertToDatabaseColumn(UUID uuid) {
        return (uuid == null ? null : uuid.toString());
    }

    @Override
    public UUID convertToEntityAttribute(String uuidString) {
        return (uuidString == null ? null : UUID.fromString(uuidString));
    }
}
