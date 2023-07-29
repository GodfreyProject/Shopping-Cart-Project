package nl.fontys.siouxparkingsystem.business;


import lombok.AllArgsConstructor;
import nl.fontys.siouxparkingsystem.business.exception.InvalidAppointmentException;
import nl.fontys.siouxparkingsystem.business.impl.AppointmentIdValidator;
import nl.fontys.siouxparkingsystem.persistence.AppointmentRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppointmentIdValidatorImpl implements AppointmentIdValidator {
    private final AppointmentRepository appointmentRepository;

    @Override
    public void validateId(Long appointmentId) {
        if (appointmentId == null || !appointmentRepository.existsById(appointmentId)) {
            throw new InvalidAppointmentException();
        }
    }
}
