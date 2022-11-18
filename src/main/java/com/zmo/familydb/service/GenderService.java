package com.zmo.familydb.service;

import com.zmo.familydb.dto.GenderDto;
import com.zmo.familydb.exception.RecordAlreadyExistsException;
import com.zmo.familydb.model.Gender;
import com.zmo.familydb.repository.GenderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class GenderService {

    private final GenderRepository genderRepository;


    public Optional<GenderDto> getGenderByGenderType(String genderType){
        Optional<GenderDto> genderDto = Optional.ofNullable(genderRepository.findByGenderType(genderType));

        return genderDto;
    }

    public GenderDto addGender(GenderDto genderDto) {
        boolean isGenderTypeAlreadyExist =
                genderRepository.existsGenderByGenderTypeIgnoreCase(genderDto.getGenderType());

        if (!isGenderTypeAlreadyExist){
            Gender gender = Gender
                    .builder()
                    .genderType(genderDto.getGenderType())
                    .build();

            genderRepository.save(gender);
            log.info("Gender type " + genderDto.getGenderType() + " is saved.");
            return new GenderDto(gender.getId(), gender.getGenderType());
        }else {
            log.error("Gender type " + genderDto.getGenderType() + " not added.");
            throw new RecordAlreadyExistsException("Gender type " + genderDto.getGenderType() + " already exists.");
        }
    }
}
