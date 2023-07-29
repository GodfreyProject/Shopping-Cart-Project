package nl.fontys.siouxparkingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;


public class ExceptionMessage extends ResponseStatusException {
    public ExceptionMessage(String errorCode){ super(HttpStatus.BAD_REQUEST, errorCode);}
}
