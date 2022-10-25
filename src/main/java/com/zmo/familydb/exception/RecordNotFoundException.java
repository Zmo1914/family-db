package com.zmo.familydb.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Record not found.")
public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        log.error(message);
        printStackTrace();
    }
}
