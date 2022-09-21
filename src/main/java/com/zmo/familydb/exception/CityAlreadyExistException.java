package com.zmo.familydb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CityAlreadyExistException extends RuntimeException {
    public CityAlreadyExistException(String city) {
        super("City " + city + " already exists.");
    }
}
