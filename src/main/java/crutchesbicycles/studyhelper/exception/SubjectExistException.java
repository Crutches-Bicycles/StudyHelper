package crutchesbicycles.studyhelper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SubjectExistException extends RuntimeException{
    public SubjectExistException(String caption){
        super("Subject with caption '" + caption + "' already exists");
    }
}
