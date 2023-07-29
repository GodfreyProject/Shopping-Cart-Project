package nl.fontys.siouxparkingsystem.business;


import lombok.AllArgsConstructor;
import nl.fontys.siouxparkingsystem.business.impl.DeleteEmployeeUseCase;
import nl.fontys.siouxparkingsystem.persistence.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteEmployeeUseCaseImpl implements DeleteEmployeeUseCase {
    private final EmployeeRepository employeeRepository;

    @Override
    public void deleteEmployee(long employeeId) {
        this.employeeRepository.deleteById(employeeId);
    }
}
