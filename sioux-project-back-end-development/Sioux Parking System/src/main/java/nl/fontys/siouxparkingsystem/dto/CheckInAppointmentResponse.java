package nl.fontys.siouxparkingsystem.dto;

import lombok.Builder;

import java.util.List;

@Builder
public class CheckInAppointmentResponse {

    private List<String> licensePlates;
}
