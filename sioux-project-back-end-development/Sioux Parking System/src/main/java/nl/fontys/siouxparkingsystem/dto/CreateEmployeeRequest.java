package nl.fontys.siouxparkingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class CreateEmployeeRequest {


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

    @NotNull
    private Long appointmentId;

}
