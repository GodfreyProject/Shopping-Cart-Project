package nl.fontys.siouxparkingsystem.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidAppointmentException extends ResponseStatusException {
    public InvalidAppointmentException() {
        super(HttpStatus.BAD_REQUEST, "APPOINTMENT_INVALID");
    }

    public InvalidAppointmentException(String errorCode) {
        super(HttpStatus.BAD_REQUEST, errorCode);
    }
}
