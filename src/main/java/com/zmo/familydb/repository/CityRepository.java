package com.zmo.familydb.repository;

import com.zmo.familydb.dto.CityDto;
import com.zmo.familydb.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<City, Integer> {

    boolean existsCityByCityNameIgnoreCase(String cityName);

    boolean existsCityByCityId(Integer cityId);

    CityDto findCityByCityId(Integer cityId);

    //Optional<CityDto> findCityByCityId(Integer cityId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM city WHERE city_name = city_name", nativeQuery = true)
    Integer deleteByName(String city_name);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM city WHERE city_id = city_id", nativeQuery = true)
    void deleteByCityId(Integer city_id);
}