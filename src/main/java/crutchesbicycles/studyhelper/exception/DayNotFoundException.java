package crutchesbicycles.studyhelper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DayNotFoundException extends RuntimeException{
    public DayNotFoundException(String message) {
        super("Day with caption '" + message + "' not found");
    }
}
