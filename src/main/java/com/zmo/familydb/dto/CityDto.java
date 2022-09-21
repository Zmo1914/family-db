package com.zmo.familydb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.zmo.familydb.model.City} entity
 */
@Data
@AllArgsConstructor
public class CityDto implements Serializable {
    private final Integer cityId;
    private final String cityName;
}