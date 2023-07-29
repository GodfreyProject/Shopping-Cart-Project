package nl.fontys.siouxparkingsystem.business;

import lombok.AllArgsConstructor;
import nl.fontys.siouxparkingsystem.business.exception.InvalidAppointmentException;
import nl.fontys.siouxparkingsystem.business.impl.UpdateAppointmentUseCase;
import nl.fontys.siouxparkingsystem.dto.UpdateAppointmentRequest;
import nl.fontys.siouxparkingsystem.persistence.AppointmentRepository;
import nl.fontys.siouxparkingsystem.persistence.entity.AppointmentEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateAppointmentUseCaseImpl implements UpdateAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;


    @Override
    public void updateAppointment(UpdateAppointmentRequest request) {
        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findById(request.getId());
        if (appointmentOptional.isEmpty()) {
            throw new InvalidAppointmentException("APPOINTMENT_ID_INVALID");
        }


        AppointmentEntity appointment = appointmentOptional.get();
        updateFields(request, appointment);
    }

    private void updateFields(UpdateAppointmentRequest request, AppointmentEntity appointment) {

        appointment.setFirstname(request.getFirstname());
        appointment.setLastname(request.getLastname());
        appointment.setDate(request.getDate());
        appointment.setEmail(request.getEmail());

        appointmentRepository.save(appointment);
    }
}
