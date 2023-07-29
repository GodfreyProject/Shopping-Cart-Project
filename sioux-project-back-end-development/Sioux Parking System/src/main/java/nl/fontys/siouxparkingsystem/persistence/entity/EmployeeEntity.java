package nl.fontys.siouxparkingsystem.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
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

    private  String date;
    @OneToOne(
            targetEntity = AppointmentEntity.class,
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "appointment_id",
            referencedColumnName = "id"
    )
    private AppointmentEntity appointment;


}
