package nl.fontys.siouxparkingsystem.business;


import lombok.AllArgsConstructor;
import nl.fontys.siouxparkingsystem.business.impl.GetEmployeeUseCase;
import nl.fontys.siouxparkingsystem.dto.Employee;
import nl.fontys.siouxparkingsystem.persistence.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetEmployeeUseCaseImpl implements GetEmployeeUseCase {

    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> getEmployee(long employeeId) {
        return employeeRepository.findById(employeeId).map(EmployeeConverter::convert);
    }
}
