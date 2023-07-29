package nl.fontys.siouxparkingsystem.persistence;

import nl.fontys.siouxparkingsystem.persistence.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findUserRoleById(Long id);
}
