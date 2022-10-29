package com.zmo.familydb.controller;

import com.zmo.familydb.dto.CityDto;
import com.zmo.familydb.exception.RecordNotFoundException;
import com.zmo.familydb.model.City;
import com.zmo.familydb.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "family_db/v1/city")
public class CityController {

    private final CityService cityService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<CityDto> registerCity(@RequestBody CityDto cityDto) {
        CityDto newCity =  cityService.AddCity(cityDto);
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{cityName}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteCity(@PathVariable("cityName") String cityName) {
        cityService.deleteCity(cityName);
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityDto> getCityBy(@PathVariable Integer cityId) {
        try {
            CityDto cityDto = cityService.getCityById(cityId).get();
            log.info("Returned City with ID " + cityDto.getCityId().toString() + " and name " + cityDto.getCityName());
            return new ResponseEntity<>(cityDto, HttpStatus.OK);
        }catch (RecordNotFoundException ex){
            ex.getMessage();
            HttpHeaders headers = new HttpHeaders();
            headers.add("message-header", "No city with ID: " + cityId);
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public List<City> getAll() {
        return cityService.getAllMembers();
    }
}