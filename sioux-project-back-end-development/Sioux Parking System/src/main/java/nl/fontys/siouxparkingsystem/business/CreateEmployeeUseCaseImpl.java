package nl.fontys.siouxparkingsystem.business;


import lombok.AllArgsConstructor;
import nl.fontys.siouxparkingsystem.business.exception.EmployeeAlreadyExistsException;
import nl.fontys.siouxparkingsystem.business.impl.AppointmentIdValidator;
import nl.fontys.siouxparkingsystem.business.impl.CreateEmployeeUseCase;
import nl.fontys.siouxparkingsystem.dto.CreateEmployeeRequest;
import nl.fontys.siouxparkingsystem.dto.CreateEmployeeResponse;
import nl.fontys.siouxparkingsystem.persistence.AppointmentRepository;
import nl.fontys.siouxparkingsystem.persistence.EmployeeRepository;
import nl.fontys.siouxparkingsystem.persistence.entity.AppointmentEntity;
import nl.fontys.siouxparkingsystem.persistence.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

;

@Service
@AllArgsConstructor
public class CreateEmployeeUseCaseImpl implements CreateEmployeeUseCase {
    private final EmployeeRepository employeeRepository;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentIdValidator appointmentIdValidator;

    @Override
    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest request) {
        if (employeeRepository.existsByFirstname(request.getFirstname())) {
            throw new EmployeeAlreadyExistsException();
        }

        appointmentIdValidator.validateId(request.getAppointmentId());

        EmployeeEntity savedEmployee = saveNewEmployee(request);

        return CreateEmployeeResponse.builder()
                .employeeId(savedEmployee.getId())
                .build();
    }

    private EmployeeEntity saveNewEmployee(CreateEmployeeRequest request) {
        AppointmentEntity appointmentEntity = appointmentRepository.findById(request.getAppointmentId()).get();
           // countryEntity.
        EmployeeEntity newEmployee = EmployeeEntity.builder()
                .appointment(appointmentEntity)
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();
        return employeeRepository.save(newEmployee);
    }
}
