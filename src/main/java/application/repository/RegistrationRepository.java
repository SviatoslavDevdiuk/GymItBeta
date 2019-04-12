package application.repository;

import application.model.RegistrationAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface RegistrationRepository extends JpaRepository<RegistrationAccess,Long> {

    @Query(value = "SELECT r FROM RegistrationAccess r WHERE r.registrationKey = ?1")
    RegistrationAccess findRegistrationKey(@RequestParam("registrationKey") String registrationKey);
}
