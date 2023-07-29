package nl.fontys.siouxparkingsystem.business;

import lombok.AllArgsConstructor;
import nl.fontys.siouxparkingsystem.business.impl.GetEmployeesUseCase;
import nl.fontys.siouxparkingsystem.dto.Employee;
import nl.fontys.siouxparkingsystem.dto.GetAllEmployeesResponse;
import nl.fontys.siouxparkingsystem.dto.GetEmployeesRequest;
import nl.fontys.siouxparkingsystem.persistence.EmployeeRepository;
import nl.fontys.siouxparkingsystem.persistence.entity.EmployeeEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class GetEmployeesUseCaseImpl implements GetEmployeesUseCase {
    private EmployeeRepository employeeRepository;

    @Override
    public GetAllEmployeesResponse getEmployees(final GetEmployeesRequest request) {
        List<EmployeeEntity> results;
        if (StringUtils.hasText(request.getDate())) {
            results = employeeRepository.findAllByDate(request.getDate());
        } else {
            results = employeeRepository.findAll();
        }

        final GetAllEmployeesResponse response = new GetAllEmployeesResponse();
        List<Employee> employees = results
                .stream()
                .map(EmployeeConverter::convert)
                .toList();
        response.setEmployees(employees);

        return response;
    }
}
