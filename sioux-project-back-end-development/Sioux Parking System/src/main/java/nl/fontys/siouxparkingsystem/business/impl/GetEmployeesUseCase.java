package nl.fontys.siouxparkingsystem.business.impl;

import nl.fontys.siouxparkingsystem.dto.GetAllEmployeesResponse;
import nl.fontys.siouxparkingsystem.dto.GetEmployeesRequest;


public interface GetEmployeesUseCase {
    GetAllEmployeesResponse getEmployees(GetEmployeesRequest request);
}
