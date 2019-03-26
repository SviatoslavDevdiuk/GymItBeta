package Application.dao;

import Application.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
//    List<Member> findByFirstName(String firstName);

    @Query("SELECT m FROM MEMBER m WHERE m.FIRST_NAME LIKE %?1")
    List<Member> findByFirstNameEndsWith(@Param("firstName")String firstName);
}
