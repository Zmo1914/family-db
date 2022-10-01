package com.zmo.familydb.service;

import com.zmo.familydb.dto.CityDto;
import com.zmo.familydb.exception.CityAlreadyExistException;
import com.zmo.familydb.exception.RecordAlreadyExistsException;
import com.zmo.familydb.model.City;
import com.zmo.familydb.repository.CityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;

    public void AddCity(CityDto cityDto) {
        boolean isCityExists = cityRepository.existsCityByCityNameIgnoreCase(cityDto.getCityName());

        if (!isCityExists) {
            City city = City.builder()
                    .cityName(cityDto.getCityName())
                    .build();

            log.info("City with name '" + cityDto.getCityName() + "' is added in the data base.");
            cityRepository.save(city);
        } else {
            log.error("City " + cityDto.getCityName() + " not added.");
            throw new RecordAlreadyExistsException(cityDto.getCityName());
        }

    }

    public Optional<CityDto> getCityById(Integer cityId) {
        return Optional.ofNullable(cityRepository.findCityByCityId(cityId));
    }

    public List<City> getAllMembers() {
        return cityRepository.findAll();
    }


}
