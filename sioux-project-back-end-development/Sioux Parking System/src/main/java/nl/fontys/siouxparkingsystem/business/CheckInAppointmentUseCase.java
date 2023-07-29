package nl.fontys.siouxparkingsystem.business;

import nl.fontys.siouxparkingsystem.dto.CheckInAppointmentRequest;
import nl.fontys.siouxparkingsystem.dto.CheckInAppointmentResponse;

public interface CheckInAppointmentUseCase {
    void checkIn(CheckInAppointmentRequest request);
}
