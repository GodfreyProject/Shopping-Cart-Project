package nl.fontys.siouxparkingsystem.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AppointementInfoAlreadyExistsException extends ResponseStatusException {
    public AppointementInfoAlreadyExistsException() {
        super(HttpStatus.BAD_REQUEST, "APPOINTMENT_ALREADY_EXISTS");
    }
}
