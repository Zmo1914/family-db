package com.zmo.familydb.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "city_id", nullable = false, updatable = false)
    @SequenceGenerator(name = "city_city_id_seq", sequenceName = "city_city_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_city_id_seq")
    private Integer cityId;

    @Column(name = "city_name", nullable = false, length = 30, columnDefinition = "TEXT")
    private String cityName;

}
