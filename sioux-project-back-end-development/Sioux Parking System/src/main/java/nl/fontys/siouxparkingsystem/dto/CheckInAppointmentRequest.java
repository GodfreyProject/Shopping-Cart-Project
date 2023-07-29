package nl.fontys.siouxparkingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckInAppointmentRequest {

    @NotBlank
    private String licensePlateNumber;
}
