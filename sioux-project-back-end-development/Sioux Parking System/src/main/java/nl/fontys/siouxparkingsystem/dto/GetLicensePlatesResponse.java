package nl.fontys.siouxparkingsystem.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetLicensePlatesResponse {

    private List<String> licensePlates;
}
