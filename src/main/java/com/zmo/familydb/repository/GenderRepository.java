package com.zmo.familydb.repository;

import com.zmo.familydb.dto.GenderDto;
import com.zmo.familydb.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GenderRepository extends JpaRepository<Gender, Integer> {


    GenderDto findByGenderType(String genderType);

    boolean existsGenderByGenderTypeIgnoreCase(String genderType);
}