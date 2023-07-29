package nl.fontys.siouxparkingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserIdAlreadyExistsException extends ResponseStatusException {
    public UserIdAlreadyExistsException() {
        super(HttpStatus.BAD_REQUEST, "USERID_ALREADY_EXISTS");
    }
}
