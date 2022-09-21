package com.zmo.familydb.controller;

import com.zmo.familydb.dto.StatusDto;
import com.zmo.familydb.exception.StatusAlreadyExistException;
import com.zmo.familydb.service.StatusService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "family_db/v1/status")
public class StatusController {

    private final StatusService statusService;

    @PostMapping
    public void registerStatus(@RequestBody StatusDto statusDto) throws StatusAlreadyExistException {
        statusService.registerStatus(statusDto);
    }
}
