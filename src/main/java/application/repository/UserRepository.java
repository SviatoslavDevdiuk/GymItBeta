package Application.dao;

import Application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select a from User a where a.user_name =?1 and a.password = ?2" )
//    User findUserByNameAndPassword(@RequestParam String userName, @RequestParam String password);

    User findByUserName(String userName);
}
