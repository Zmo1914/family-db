package com.zmo.familydb.controller;

import com.zmo.familydb.dto.GenderDto;
import com.zmo.familydb.model.Gender;
import com.zmo.familydb.service.GenderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "family_db/v1/gender")
public class GenderController {
    private final GenderService genderService;

    @GetMapping("/{genderType}")
    public ResponseEntity<GenderDto> getByGenderType(@PathVariable String genderType){
        GenderDto genderDto = genderService.getGenderByGenderType(genderType).get();
        return new ResponseEntity<>(genderDto, HttpStatus.FOUND);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<GenderDto> registerGender(@RequestBody GenderDto genderDto){
        GenderDto newGenderType = genderService.addGender(genderDto);
        return new ResponseEntity<>(newGenderType, HttpStatus.CREATED);
    }
}
