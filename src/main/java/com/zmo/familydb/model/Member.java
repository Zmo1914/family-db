package com.zmo.familydb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "surename", length = 30)
    private String surename;

    @Column(name = "family_name", length = 30)
    private String familyName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gender_fk", nullable = false)
    private Gender genderFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "birth_city_fk")
    private City birthCityFk;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "death_date")
    private LocalDate deathDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_fk")
    private Status statusFk;

    @Column(name = "\"isActive\"", length = 30)
    private String isActive;
}