package nl.fontys.siouxparkingsystem.controller;


import lombok.AllArgsConstructor;
import nl.fontys.siouxparkingsystem.business.impl.*;
import nl.fontys.siouxparkingsystem.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final CreateEmployeeUseCase createEmployeeUseCase;

    private  final GetEmployeesUseCase getEmployeesUseCase;

    private final GetEmployeeUseCase getEmployeeUseCase;

    private  final UpdateEmployeeUseCase updateEmployeeUseCase;

    private  final DeleteEmployeeUseCase deleteEmployeeUseCase;
    @GetMapping
    public ResponseEntity<GetAllEmployeesResponse> getAllEmployees(@RequestParam(value = "country", required = false) String countryCode) {
        GetEmployeesRequest request = GetEmployeesRequest.builder().date(countryCode).build();
        GetAllEmployeesResponse response = getEmployeesUseCase.getEmployees(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateEmployeeResponse> createEmployee(@RequestBody @Valid CreateEmployeeRequest request) {
        CreateEmployeeResponse response = createEmployeeUseCase.createEmployee(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("{employeeId}")
    public ResponseEntity<Employee> getStudent(@PathVariable(value = "employeeId") final long employeeId) {
        final Optional<Employee> employeeOptional = getEmployeeUseCase.getEmployee(employeeId);
        if (employeeOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employeeOptional.get());
    }

    @PutMapping("{employeeId}")
    public ResponseEntity<Void> updateStudent(@PathVariable("employeeId") long employeeId,
                                              @RequestBody @Valid UpdateEmployeeRequest request) {
        request.setId(employeeId);
        updateEmployeeUseCase.updateEmployee(request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        deleteEmployeeUseCase.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }
}
