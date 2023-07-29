package nl.fontys.siouxparkingsystem.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    private Long id;
    @NotNull(message = "User Full name can not be Empty")
    private String firstname;
    @NotNull(message = "User Full name can not be Empty")
    private String lastname;

    @Email(message = "Invalid email Address Provided")
    private String email;

    private String licensePlate;


    private String date;

    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile Number provided")
    private String phoneNumber;





}
