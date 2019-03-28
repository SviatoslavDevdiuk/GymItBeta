package Application.dao;

import Application.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
//    List<Member> findByFirstName(String firstName);

//    @Query(value = "from Member where firstName = ?1",nativeQuery = true)
    @Query(value = "SELECT m FROM Member m WHERE m.firstName LIKE %?1")
    List<Member> findByFirstNameEndsWith(@Param("firstName")String firstName);
}
