package nl.fontys.siouxparkingsystem.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmployeeAlreadyExistsException extends ResponseStatusException {

    public EmployeeAlreadyExistsException() {
        super(HttpStatus.BAD_REQUEST, "EMPLOYEEINFO_ALREADY_EXISTS");
    }
}
