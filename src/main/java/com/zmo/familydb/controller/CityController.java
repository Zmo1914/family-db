package com.zmo.familydb.controller;

import com.zmo.familydb.dto.CityDto;
import com.zmo.familydb.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "family_db/v1/city")

public class CityController {

    private final CityService cityService;

    @PostMapping
    public void registerCity(@RequestBody CityDto cityDto){
        cityService.AddCity(cityDto);
    }
}
