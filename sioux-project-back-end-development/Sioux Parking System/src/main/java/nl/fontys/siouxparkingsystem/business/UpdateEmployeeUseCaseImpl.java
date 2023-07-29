package nl.fontys.siouxparkingsystem.business;


import lombok.AllArgsConstructor;
import nl.fontys.siouxparkingsystem.business.exception.InvalidEmployeeException;
import nl.fontys.siouxparkingsystem.business.impl.AppointmentIdValidator;
import nl.fontys.siouxparkingsystem.business.impl.UpdateEmployeeUseCase;
import nl.fontys.siouxparkingsystem.dto.UpdateEmployeeRequest;
import nl.fontys.siouxparkingsystem.persistence.AppointmentRepository;
import nl.fontys.siouxparkingsystem.persistence.EmployeeRepository;
import nl.fontys.siouxparkingsystem.persistence.entity.AppointmentEntity;
import nl.fontys.siouxparkingsystem.persistence.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateEmployeeUseCaseImpl implements UpdateEmployeeUseCase {
    private final EmployeeRepository employeeRepository;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentIdValidator appointmentIdValidator;

    @Override
    public void updateEmployee(UpdateEmployeeRequest request) {
        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(request.getId());
        if (employeeOptional.isEmpty()) {
            throw new InvalidEmployeeException("EMPLOYEE_ID_INVALID");
        }

        appointmentIdValidator.validateId(request.getAppointmentId());

        EmployeeEntity employee = employeeOptional.get();
        updateFields(request, employee);
    }

    private void updateFields(UpdateEmployeeRequest request, EmployeeEntity employee) {
        AppointmentEntity appointmentEntity = appointmentRepository.findById(request.getAppointmentId()).get();

        employee.setAppointment(appointmentEntity);

        employee.setFirstname(request.getFirstname());
        employee.setLastname(request.getLastname());
        employee.setEmail(request.getEmail());
        employee.setPhoneNumber(request.getPhoneNumber());
        employeeRepository.save(employee);
    }
}
