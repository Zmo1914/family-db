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
import java.util.NoSuchElementException;
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
            log.info("City with name '" + cityDto.getCityName() + "' is added.");
        } else {
            log.error("City " + cityDto.getCityName() + " not added.");
            throw new RecordAlreadyExistsException("City with name " + cityDto.getCityName() + " already exists.");
        }
    }


    public Optional<CityDto> getCityById(Integer cityId) {
        Optional<CityDto> city;

        if (cityRepository.existsCityByCityId(cityId)){
            city = Optional.ofNullable(cityRepository.findCityByCityId(cityId));
        }else {
            throw new RecordNotFoundException("City not found");
        }
        return city;
    }


    public List<City> getAllMembers() {
        List<City> allCities = cityRepository.findAll();
        if (allCities.size() == 0) {
            log.info("No cities found. Empty.");
        }
        return allCities;
    }

    public void deleteCity(String cityName) {
        try {
            isCityExists(cityName);
            cityRepository.deleteByName(cityName);
            log.info("City with name '" + cityName + "' is deleted.");
        } catch (RecordNotFoundException ex) {
            log.error(ex.getMessage());
        }
    }

    private boolean isCityExists(String cityName) {
       if(cityRepository.existsCityByCityNameIgnoreCase(cityName)) {
           return true;
       }
        throw new RecordNotFoundException("City '" + cityName + "' not found.");
    }

    private boolean isCityExists(Integer cityId) {
        if (cityRepository.existsCityByCityId(cityId))
            return true;
        throw new RecordNotFoundException("City not found.");
    }


    public void deleteCity(Integer cityId) {
        boolean isCityExists = cityRepository.existsCityByCityId(cityId);

        if (isCityExists) {
            cityRepository.deleteByCityId(cityId);
            log.info("City with id '" + cityId + "' is deleted.");
        } else {
            throw new RecordNotFoundException("City with id '" + cityId + "' not found.");
        }
    }
}



