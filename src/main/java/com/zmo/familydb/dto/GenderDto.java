package com.zmo.familydb.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.zmo.familydb.model.Gender} entity
 */
@Data
public class GenderDto implements Serializable {
    private final Integer id;
    private final String genderType;
}