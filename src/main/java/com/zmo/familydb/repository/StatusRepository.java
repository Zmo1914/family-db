package com.zmo.familydb.repository;

import com.zmo.familydb.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

    boolean existsStatusByStatus(String status);

}