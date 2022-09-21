package com.zmo.familydb.repository;

import com.zmo.familydb.dto.CityDto;
import com.zmo.familydb.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    boolean existsCityByCityNameIgnoreCase(String cityName);
    CityDto findCityByCityId(Integer cityId);
}