package nl.fontys.siouxparkingsystem.business.impl;


import nl.fontys.siouxparkingsystem.business.exception.InvalidAppointmentException;

public interface AppointmentIdValidator {
    void validateId(Long appointmentId) throws InvalidAppointmentException;
}
