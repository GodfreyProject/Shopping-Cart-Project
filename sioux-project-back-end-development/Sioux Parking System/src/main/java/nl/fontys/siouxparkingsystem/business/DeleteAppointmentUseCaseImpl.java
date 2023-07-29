package nl.fontys.siouxparkingsystem.business;


import lombok.AllArgsConstructor;
import nl.fontys.siouxparkingsystem.business.impl.DeleteAppointmentUseCase;
import nl.fontys.siouxparkingsystem.persistence.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteAppointmentUseCaseImpl implements DeleteAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;

    @Override
    public void deleteAppointment(long appointmentId) {
        this.appointmentRepository.deleteById(appointmentId);
    }
}
