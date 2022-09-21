package com.zmo.familydb.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Status")
@Table(name = "status")
public class Status {

    @Id
    @Column(name = "status_id", nullable = false, updatable = false)
    @SequenceGenerator(name = "status_status_id_seq", sequenceName = "status_status_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_status_id_seq")
    private Integer statusId;

    @Column(name = "status", nullable = false, length = 30, columnDefinition = "TEXT")
    private String status;
}
