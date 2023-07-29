package nl.fontys.siouxparkingsystem.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
