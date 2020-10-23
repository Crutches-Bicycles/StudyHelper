package crutchesbicycles.studyhelper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GroupExistsException extends RuntimeException {
    public GroupExistsException(String email, String caption){
        super("Group with email '" + email + "' or caption '" + caption + "' not found");
    }
}
