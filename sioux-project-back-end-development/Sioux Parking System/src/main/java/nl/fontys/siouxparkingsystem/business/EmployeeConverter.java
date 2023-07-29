package nl.fontys.siouxparkingsystem.business;

import nl.fontys.siouxparkingsystem.dto.Employee;
import nl.fontys.siouxparkingsystem.persistence.entity.EmployeeEntity;

public class EmployeeConverter {
    private EmployeeConverter() {
    }

    public static Employee convert(EmployeeEntity employee) {
        return Employee.builder().id(employee.getId()).firstname(employee.getFirstname())
                .lastname(employee.getLastname())
                .email(employee.getEmail()).
                phoneNumber(employee.getPhoneNumber())
                .appointment(AppointmentConverter.convert(employee.getAppointment())).build();
    }
}

