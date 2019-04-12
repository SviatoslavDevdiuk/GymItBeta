package application.repository;

import application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select a from User a where a.user_name =?1 and a.password = ?2" )
//    User findUserByNameAndPassword(@RequestParam String userName, @RequestParam String password);

    User findByUserName(String userName);
}
