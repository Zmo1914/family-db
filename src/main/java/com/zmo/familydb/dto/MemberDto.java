package com.zmo.familydb.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.zmo.familydb.model.Member} entity
 */
@Data
public class MemberDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String sureName;
    private final String familyName;
    private final GenderDto genderFk;
    private final CityDto birthCityFk;
    private final LocalDate birthDate;
    private final LocalDate deathDate;
    private final StatusDto statusFk;
    private final String isActive;
}