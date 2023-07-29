package nl.fontys.siouxparkingsystem.business.impl;

import lombok.RequiredArgsConstructor;
import nl.fontys.siouxparkingsystem.business.CheckInAppointmentUseCase;
import nl.fontys.siouxparkingsystem.configuration.Email;
import nl.fontys.siouxparkingsystem.configuration.EmailSenderService;
import nl.fontys.siouxparkingsystem.dto.CheckInAppointmentRequest;
import nl.fontys.siouxparkingsystem.persistence.AppointmentRepository;
import nl.fontys.siouxparkingsystem.persistence.EmployeeRepository;
import nl.fontys.siouxparkingsystem.persistence.entity.AppointmentEntity;
import nl.fontys.siouxparkingsystem.persistence.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInAppointmentUseCaseImpl implements CheckInAppointmentUseCase {

    private final AppointmentRepository appointmentRepository;

    private final Email email;

    private final EmployeeRepository employeeRepository;
    @Override
    public void checkIn(CheckInAppointmentRequest request) {
        AppointmentEntity appointment = appointmentRepository.findByLicensePlate(request.getLicensePlateNumber());
        String customerEmail = appointment.getEmail();
        //Capacity logic would be used here to dictate which emails get send
        email.sendCapacityMail(appointment.getFirstname(), customerEmail);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(appointment.getEmployeeId());
        //Employee gets notified of their visitor's arrival
        email.sendEmployeeMail(employeeEntity.get().getEmail(), appointment);
    }
}
