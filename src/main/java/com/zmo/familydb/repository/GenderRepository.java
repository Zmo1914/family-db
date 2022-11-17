package com.zmo.familydb.repository;

import com.zmo.familydb.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenderRepository extends JpaRepository<Gender, Integer> {

}