package nl.fontys.siouxparkingsystem.business.impl;


import nl.fontys.siouxparkingsystem.dto.Employee;

import java.util.Optional;

public interface GetEmployeeUseCase {
    Optional<Employee> getEmployee(long employeeId);
}
