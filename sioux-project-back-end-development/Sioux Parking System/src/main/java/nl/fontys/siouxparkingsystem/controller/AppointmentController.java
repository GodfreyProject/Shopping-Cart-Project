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
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000/")
@AllArgsConstructor
public class AppointmentController {



    private final GetAppointmentsUseCase getAppointmentsUseCase;

    private  final CreateAppointmentUseCase createAppointmentUseCase;

    private  final GetAppointmentUseCase getAppointmentUseCase;

    private  final DeleteAppointmentUseCase deleteAppointmentUseCase;

    private final UpdateAppointmentUseCase updateAppointmentUseCase;
    @GetMapping
    public ResponseEntity<GetAllAppointmentsResponse> getAppointment() {
        return ResponseEntity.ok(getAppointmentsUseCase.getAppointments());
    }

    @PostMapping()
    public ResponseEntity<CreateAppointmentResponse> createAppointment(@RequestBody @Valid CreateAppointmentRequest request) {
        CreateAppointmentResponse response = createAppointmentUseCase.createAppointment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("{appointmentId}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable(value = "appointmentId") final long appointmentId) {
        final Optional<Appointment> appointmentOptional = getAppointmentUseCase.getAppointment(appointmentId);
        if (appointmentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(appointmentOptional.get());
    }

    @PutMapping("{appointmentId}")
    public ResponseEntity<Void> updateStudent(@PathVariable("appointmentId") long appointmentId,
                                              @RequestBody @Valid UpdateAppointmentRequest request) {
        request.setId(appointmentId);
        updateAppointmentUseCase.updateAppointment(request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long appointmentId) {
        deleteAppointmentUseCase.deleteAppointment(appointmentId);
        return ResponseEntity.noContent().build();
    }
}
