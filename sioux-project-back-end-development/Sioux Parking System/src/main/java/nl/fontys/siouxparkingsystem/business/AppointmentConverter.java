package nl.fontys.siouxparkingsystem.business;


import nl.fontys.siouxparkingsystem.dto.Appointment;
import nl.fontys.siouxparkingsystem.persistence.entity.AppointmentEntity;

public class AppointmentConverter {
    private AppointmentConverter() {
    }

    public static Appointment convert(AppointmentEntity appointment) {
        return Appointment.builder().id(appointment.getId()).firstname(appointment.getFirstname()).lastname(appointment.getLastname()).email(appointment.getEmail()).date(appointment.getDate()).licensePlate(appointment.getLicensePlate()).phoneNumber(appointment.getPhoneNumber()).build();
    }
}

