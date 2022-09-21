package com.zmo.familydb.controller;

import com.zmo.familydb.dto.CityDto;
import com.zmo.familydb.exception.RecordNotFoundException;
import com.zmo.familydb.model.City;
import com.zmo.familydb.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public void registerCity(@RequestBody CityDto cityDto) {
        cityService.AddCity(cityDto);
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<City> getCityBy(@PathVariable Integer cityId) throws RecordNotFoundException {
        Optional<City> city = cityService.getCityById(cityId);
        if (city.isPresent()) {
            return new ResponseEntity<>(city.get(), HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("No city with id '" + cityId + "' not found.");
        }
    }

    @GetMapping("/all")
    public List<City> getAll() {
        return cityService.getAllMembers();
    }
}
