package com.zmo.familydb.service;

import com.zmo.familydb.dto.CityDto;
import com.zmo.familydb.exception.RecordAlreadyExistsException;
import com.zmo.familydb.exception.RecordNotFoundException;
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
            City city = City
                    .builder()
                    .cityName(cityDto.getCityName())
                    .build();

            cityRepository.save(city);
            log.info("City with name '" + cityDto.getCityName() + "' is added in the data base.");
        } else {
            log.error("City " + cityDto.getCityName() + " not added.");
            throw new RecordAlreadyExistsException("City with name " + cityDto.getCityName() + " already exists.");
        }
    }

    public Optional<CityDto> getCityById(Integer cityId) {
        boolean isCityExists = cityRepository.existsCityByCityId(cityId);

        if (isCityExists) {
            return Optional.ofNullable(cityRepository.findCityByCityId(cityId));
        }else {
            log.error("City with id '" + cityId + "' not exists.");
            throw new RecordNotFoundException("City with id " + cityId.toString() + " not found.");
        }
    }

    public List<City> getAllMembers() {
        List<City> allCities = cityRepository.findAll();
        if (allCities.size() == 0){
            log.info("No cities found. Empty.");
        }
        return allCities;
    }


}
