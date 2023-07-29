package nl.fontys.siouxparkingsystem.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Employee {


    @NotNull
    private Long id;
    @NotNull(message = "User Full name can not be Empty")
    private String firstname;
    @NotNull(message = "User Full name can not be Empty")
    private String lastname;

    @Email(message = "Invalid email Address Provided")
    private String email;

    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile Number provided")
    private String phoneNumber;


    private Appointment appointment;


}
