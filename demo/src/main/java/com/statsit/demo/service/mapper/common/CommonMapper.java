package com.statsit.demo.service.mapper.common;

import java.time.Instant;

import org.mapstruct.Named;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommonMapper {

    @Named("stringToInt")
    default Integer stringToInt(String value) {
        return value == null || value.isBlank() ? 0 : Integer.parseInt(value);
    }

    @Named("intToString")
    default String intToString (Integer value) {
        return value == null ? null : String.valueOf(value);
    }

    @Named("stringToIntNullable")
    default Integer stringToIntNullable(String value) {
        return value == null || value.isBlank() ? null : Integer.valueOf(value);
    }

    @Named("stringToDouble")
    default Double stringToDouble(String value) {
        return value == null || value.isBlank() ? null : Double.valueOf(value);
    }

    @Named("instantToMillis")
    default Long instantToMillis(Instant instant) {
        return instant == null ? 0L : instant.toEpochMilli();
    }

    @Named("stringToInstant")
    default Instant stringToInstant(String value) {
        try {
            return value == null ? null : Instant.parse(value);
        } catch (Exception e) {
            return null;
        }
    }

    @Named("stringToBoolean")
    default Boolean stringToBoolean(String value) {
        return "true".equalsIgnoreCase(value);
    }

    @Named("integerToBoolean")
    default Boolean integerToBoolean(Integer value) {
        return value == 1;
    }
}
