package com.zmo.familydb.service;

import com.zmo.familydb.dto.StatusDto;
import com.zmo.familydb.exception.StatusAlreadyExistException;
import com.zmo.familydb.model.Status;
import com.zmo.familydb.repository.StatusRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public void registerStatus(StatusDto statusDto) throws StatusAlreadyExistException {

        boolean isExists = statusRepository.existsStatusByStatus(statusDto.getStatus());
        if (isExists) {
            log.error("Could not add this status.");
            throw new StatusAlreadyExistException(statusDto.getStatus());
        }

        Status status = Status
                .builder()
                .status(statusDto.getStatus())
                .build();

        statusRepository.save(status);
        log.info("Status " + statusDto.getStatus() + " is added.");
    }

    public List<Status> getAllStatuses() {
        List<Status> allStatuses = statusRepository.findAll();
        if (allStatuses.isEmpty()) {
            log.info("No statuses found.");
        }
        return allStatuses;
    }
}


