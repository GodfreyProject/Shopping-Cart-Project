package nl.fontys.siouxparkingsystem.persistence;

import nl.fontys.siouxparkingsystem.persistence.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    boolean existsByEmail(String email);

    //boolean existsByFirstName(String firstname);

//    boolean existsByUsername(String userName);

    List<AppointmentLicensePlate> findAllBy();

    boolean existsByFirstname(String firstName);

    AppointmentEntity findByLicensePlate(String licensePlate);

    //public Appointment findByuserId(Long id);
    //public Optional<Appointment> findById(Long roleId) ;
    //public Appointment findByAppointId(Long appointId) ;

//    @Override
//    public Optional<Appointment> findById(long appointId) {
//        return this.save.stream()
//                .filter(appointment -> appointment.equals(studentId))
//                .findFirst();
//    }
}
