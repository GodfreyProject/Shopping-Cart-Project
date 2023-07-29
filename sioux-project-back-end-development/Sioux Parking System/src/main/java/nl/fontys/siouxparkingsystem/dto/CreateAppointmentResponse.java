package nl.fontys.siouxparkingsystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAppointmentResponse {
    private Long appointmentId;
}
