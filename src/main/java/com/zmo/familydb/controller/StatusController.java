package com.zmo.familydb.controller;

import com.zmo.familydb.dto.StatusDto;
import com.zmo.familydb.exception.StatusAlreadyExistException;
import com.zmo.familydb.model.Status;
import com.zmo.familydb.service.StatusService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "family_db/v1/status")
public class StatusController {

    private final StatusService statusService;

    @PostMapping
    public void registerStatus(@RequestBody StatusDto statusDto) {
        statusService.registerStatus(statusDto);
    }

    @GetMapping("/all")
    public List<Status> getAll(){
        return statusService.getAllStatuses();
    }
}
