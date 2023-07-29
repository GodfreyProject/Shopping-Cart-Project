package nl.fontys.siouxparkingsystem.business;

import lombok.AllArgsConstructor;
import nl.fontys.siouxparkingsystem.business.exception.AppointementInfoAlreadyExistsException;
import nl.fontys.siouxparkingsystem.business.impl.CreateAppointmentUseCase;
import nl.fontys.siouxparkingsystem.dto.CreateAppointmentRequest;
import nl.fontys.siouxparkingsystem.dto.CreateAppointmentResponse;
import nl.fontys.siouxparkingsystem.persistence.AppointmentRepository;
import nl.fontys.siouxparkingsystem.persistence.entity.AppointmentEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAppointmentUseCaseImpl implements CreateAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;

    @Override
    public CreateAppointmentResponse createAppointment(CreateAppointmentRequest request) {
        if (appointmentRepository.existsByFirstname(request.getFirstname())) {
            throw new AppointementInfoAlreadyExistsException();
        }



        AppointmentEntity savedAppointment = saveNewAppointment(request);

        return CreateAppointmentResponse.builder()
                .appointmentId(savedAppointment.getId())
                .build();
    }

    private AppointmentEntity saveNewAppointment(CreateAppointmentRequest request) {
        //CountryEntity countryEntity = countryRepository.findById(request.getCountryId());
           // countryEntity.
        AppointmentEntity newAppointment = AppointmentEntity.builder()
                .id(request.getId())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .date(request.getDate())
                .licensePlate(request.getLicensePlate())
                .phoneNumber(request.getPhoneNumber())
                .build();
        return appointmentRepository.save(newAppointment);
    }
}
