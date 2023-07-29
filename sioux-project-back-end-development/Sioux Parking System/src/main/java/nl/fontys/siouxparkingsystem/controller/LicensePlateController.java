package nl.fontys.siouxparkingsystem.controller;

import lombok.AllArgsConstructor;
import nl.fontys.siouxparkingsystem.business.CheckInAppointmentUseCase;
import nl.fontys.siouxparkingsystem.business.GetLicensePlatesUseCase;
import nl.fontys.siouxparkingsystem.dto.CheckInAppointmentRequest;
import nl.fontys.siouxparkingsystem.dto.CheckInAppointmentResponse;
import nl.fontys.siouxparkingsystem.dto.GetLicensePlatesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/licensePlate")
@AllArgsConstructor
@CrossOrigin(origins = "Insert origin here")
public class LicensePlateController {

    private final CheckInAppointmentUseCase checkInAppointmentUseCase;

    private final GetLicensePlatesUseCase getLicensePlatesUseCase;

    @PostMapping
    public ResponseEntity<CheckInAppointmentResponse> checkIn(@RequestBody @Valid CheckInAppointmentRequest request) {
        checkInAppointmentUseCase.checkIn(request);
        CheckInAppointmentResponse response = CheckInAppointmentResponse.builder()
                .licensePlates(getLicensePlatesUseCase.Get().getLicensePlates())
                .build();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @GetMapping
    public ResponseEntity<GetLicensePlatesResponse> getLicensePlates() {
        GetLicensePlatesResponse response = getLicensePlatesUseCase.Get();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
