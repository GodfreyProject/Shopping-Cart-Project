package nl.fontys.siouxparkingsystem.persistence;

import nl.fontys.siouxparkingsystem.persistence.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    boolean existsByEmail(String email);

    boolean existsByFirstname(String firstname);

    List<EmployeeEntity> findAllByDate(String date);
}
