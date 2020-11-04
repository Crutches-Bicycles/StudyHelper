package crutchesbicycles.studyhelper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String email) {
        super("Account Not Found (" + email + ")" );
    }
}
