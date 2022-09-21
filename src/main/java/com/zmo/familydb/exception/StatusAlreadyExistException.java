package com.zmo.familydb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class StatusAlreadyExistException extends RuntimeException {
    public StatusAlreadyExistException(String status) {
        super("Status " + status + " already exists.");
    }
}
