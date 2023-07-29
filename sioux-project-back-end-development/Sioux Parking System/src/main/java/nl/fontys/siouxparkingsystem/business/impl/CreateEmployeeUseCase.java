package nl.fontys.siouxparkingsystem.business.impl;


import nl.fontys.siouxparkingsystem.dto.CreateEmployeeRequest;
import nl.fontys.siouxparkingsystem.dto.CreateEmployeeResponse;


public interface CreateEmployeeUseCase {
    CreateEmployeeResponse createEmployee(CreateEmployeeRequest request);
}
