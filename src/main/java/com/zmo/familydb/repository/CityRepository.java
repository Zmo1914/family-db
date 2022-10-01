package com.zmo.familydb.repository;

import com.zmo.familydb.dto.CityDto;
import com.zmo.familydb.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<City, Integer> {

    boolean existsCityByCityNameIgnoreCase(String cityName);

    boolean existsCityByCityId(Integer cityId);

    CityDto findCityByCityId(Integer cityId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM city WHERE city_name = city_name", nativeQuery = true)
    Integer deleteByName(String city_name);


}