package crutchesbicycles.studyhelper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(String idGroup) {
        super("Group with id '" + idGroup + "' not found");
    }
}
