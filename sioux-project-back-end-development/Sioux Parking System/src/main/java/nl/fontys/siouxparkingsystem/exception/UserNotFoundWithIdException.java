package nl.fontys.siouxparkingsystem.exception;

public class UserNotFoundWithIdException extends Exception {
    public UserNotFoundWithIdException(String message) {
        super(message);
    }
}
