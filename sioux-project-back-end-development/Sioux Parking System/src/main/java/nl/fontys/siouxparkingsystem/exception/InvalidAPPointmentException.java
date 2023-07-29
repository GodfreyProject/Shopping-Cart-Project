package nl.fontys.siouxparkingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidAPPointmentException extends ResponseStatusException {
    public InvalidAPPointmentException(String errorCode) {
        super(HttpStatus.BAD_REQUEST, errorCode);
    }
}