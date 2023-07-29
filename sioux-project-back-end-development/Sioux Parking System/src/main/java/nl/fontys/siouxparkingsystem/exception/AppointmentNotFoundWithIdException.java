package nl.fontys.siouxparkingsystem.exception;

public class AppointmentNotFoundWithIdException extends Exception{

    public AppointmentNotFoundWithIdException(String message) {
        super(message);
    }
}
