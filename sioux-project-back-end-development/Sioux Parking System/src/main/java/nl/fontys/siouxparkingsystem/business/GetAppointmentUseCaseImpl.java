package nl.fontys.siouxparkingsystem.business;



import lombok.AllArgsConstructor;
import nl.fontys.siouxparkingsystem.business.exception.InvalidAppointmentException;
import nl.fontys.siouxparkingsystem.business.impl.GetAppointmentUseCase;
import nl.fontys.siouxparkingsystem.dto.Appointment;
import nl.fontys.siouxparkingsystem.persistence.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetAppointmentUseCaseImpl implements GetAppointmentUseCase {

    private AppointmentRepository appointmentRepository;

    @Override
    public Optional<Appointment> getAppointment(long appointmentId) {

        if(appointmentRepository.findById(appointmentId) == null)
        {
            throw new InvalidAppointmentException();
        }
        return appointmentRepository.findById(appointmentId).map(AppointmentConverter::convert);
    }
}
