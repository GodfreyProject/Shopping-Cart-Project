package nl.fontys.siouxparkingsystem.configuration;

import nl.fontys.siouxparkingsystem.persistence.entity.AppointmentEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class Email {

    @Autowired
    private EmailSenderService senderService;

    public void sendCapacityMail(String customerName, String customerEmail) {
         String body = "Hello " + customerName +
                System.lineSeparator() + " Unfortunately there are no parking slots available at our office, therefor we ask you to park somewhere else." + System.lineSeparator()
                + "We suggest our larger parking lot (address of parking lot) which is a 2 minute drive from here and you can follow these directions......."+ System.lineSeparator() + "https://www.google.com/maps/dir/Sioux+Technologies+B.V.,+Esp+130,+5633+AA+Eindhoven/51.4898897,5.4896616/@51.488645,5.4895099,17.5z/data=!4m9!4m8!1m5!1m1!1s0x47c6dedeeba2d4d5:0x36047c225b4a20fd!2m2!1d5.489148!2d51.487449!1m0!3e1" + System.lineSeparator() + "if there are any problems feel free to call us at xx-xx-xx-xx";
         senderService.sendEmail(customerEmail,
                "Sioux Parking", body);
    }

    public void sendEmployeeMail(String employeeEmail, AppointmentEntity appointment) {
        String body = "Meeting details will be here";
        senderService.sendEmail(employeeEmail,
                "Sioux Parking", body);
    }
}
