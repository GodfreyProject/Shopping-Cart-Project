package nl.fontys.siouxparkingsystem.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AppointmentIdNOtFoundException extends ResponseStatusException {
    public AppointmentIdNOtFoundException() {
        super(HttpStatus.NOT_FOUND , "APPOINTMENT_ID_NOTFOUND");
    }
}
