package nl.fontys.siouxparkingsystem.business.impl;


import nl.fontys.siouxparkingsystem.dto.Appointment;

import java.util.Optional;

;

public interface GetAppointmentUseCase {
    Optional<Appointment> getAppointment(long appointmentId);
}
