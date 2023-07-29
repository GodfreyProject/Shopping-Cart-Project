package nl.fontys.siouxparkingsystem.business;

import lombok.AllArgsConstructor;
import nl.fontys.siouxparkingsystem.business.impl.GetAppointmentsUseCase;
import nl.fontys.siouxparkingsystem.dto.Appointment;
import nl.fontys.siouxparkingsystem.dto.GetAllAppointmentsResponse;
import nl.fontys.siouxparkingsystem.persistence.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAppointmentsUseCaseImpl implements GetAppointmentsUseCase {
    private AppointmentRepository appointmentRepository;

    @Override
    public GetAllAppointmentsResponse getAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll()
                .stream()
                .map(AppointmentConverter::convert)
                .toList();

        return GetAllAppointmentsResponse.builder()
                .appointments(appointments)
                .build();
    }
}
