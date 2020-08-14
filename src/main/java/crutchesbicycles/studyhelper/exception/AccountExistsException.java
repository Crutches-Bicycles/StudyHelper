package crutchesbicycles.studyhelper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountExistsException extends RuntimeException {
    public AccountExistsException(String email) {
        super("Account can't be created, because user with same email (" + email + ") exists" );
    }
}
