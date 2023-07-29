package nl.fontys.siouxparkingsystem.business.impl;



import nl.fontys.siouxparkingsystem.dto.UpdateAppointmentRequest;

public interface UpdateAppointmentUseCase {
    void updateAppointment(UpdateAppointmentRequest request);
}
