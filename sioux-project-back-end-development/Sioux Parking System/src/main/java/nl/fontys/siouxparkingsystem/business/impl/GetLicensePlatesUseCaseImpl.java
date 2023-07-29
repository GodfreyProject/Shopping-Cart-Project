package nl.fontys.siouxparkingsystem.business.impl;

import lombok.RequiredArgsConstructor;
import nl.fontys.siouxparkingsystem.business.GetLicensePlatesUseCase;
import nl.fontys.siouxparkingsystem.business.exception.AppointmentIdNOtFoundException;
import nl.fontys.siouxparkingsystem.dto.GetLicensePlatesResponse;
import nl.fontys.siouxparkingsystem.persistence.AppointmentLicensePlate;
import nl.fontys.siouxparkingsystem.persistence.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetLicensePlatesUseCaseImpl implements GetLicensePlatesUseCase {

    private final AppointmentRepository appointmentRepository;
    @Override
    public GetLicensePlatesResponse Get() {
        List<AppointmentLicensePlate> appointmentLicensePlates = appointmentRepository.findAllBy();
        if (!appointmentLicensePlates.isEmpty()) {
            List<String> licensePlates = new ArrayList<>();
            int i;
            for (i = 1; i <= appointmentLicensePlates.size(); i++) {
                licensePlates.add(appointmentLicensePlates.get(i - 1).getLicensePlate());
            }
            GetLicensePlatesResponse response = GetLicensePlatesResponse.builder()
                    .licensePlates(licensePlates)
                    .build();
            return response;
        }
        throw new AppointmentIdNOtFoundException();
    }
}
