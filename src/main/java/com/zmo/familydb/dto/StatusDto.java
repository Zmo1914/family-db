package com.zmo.familydb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.zmo.familydb.model.Status} entity
 */
@Data
@AllArgsConstructor
public class StatusDto implements Serializable {
    private final Integer statusId;
    private final String status;
}