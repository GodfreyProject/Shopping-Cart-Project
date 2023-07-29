package nl.fontys.siouxparkingsystem.business.impl;

import nl.fontys.siouxparkingsystem.dto.CreateAppointmentRequest;
import nl.fontys.siouxparkingsystem.dto.CreateAppointmentResponse;


public interface CreateAppointmentUseCase {
    CreateAppointmentResponse createAppointment(CreateAppointmentRequest request);
}
