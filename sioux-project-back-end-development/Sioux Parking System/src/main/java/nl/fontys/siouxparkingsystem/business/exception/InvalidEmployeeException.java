package nl.fontys.siouxparkingsystem.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidEmployeeException extends ResponseStatusException {
    public InvalidEmployeeException(String errorCode) {
        super(HttpStatus.BAD_REQUEST, errorCode);
    }
}