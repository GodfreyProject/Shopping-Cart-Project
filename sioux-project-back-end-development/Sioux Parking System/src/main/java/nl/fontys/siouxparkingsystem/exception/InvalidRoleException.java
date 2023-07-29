package nl.fontys.siouxparkingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class InvalidRoleException extends ResponseStatusException {
    public InvalidRoleException() {
        super(HttpStatus.BAD_REQUEST, "ROLE_INVALID");
    }

    public InvalidRoleException(Long roleId) {
        super(HttpStatus.BAD_REQUEST, String.valueOf(roleId));
    }
}
