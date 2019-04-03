package Application.dao;

import Application.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    @Query("select a from Administrator a where a.userName =?1 and a.password = ?2" )
    Administrator findAdministratorByNameAndPassword(@RequestParam String userName, @RequestParam String password);
}
