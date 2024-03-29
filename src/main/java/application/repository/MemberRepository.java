package application.repository;

import application.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
//    List<Member> findByFirstName(String firstName);

//    @Query(value = "from Member where firstName = ?1",nativeQuery = true)
    @Query(value = "SELECT m FROM Member m WHERE m.firstName LIKE %?1")
    List<Member> findByFirstNameEndsWith(@Param("firstName")String firstName);

    @Query(value = "DELETE m FROM Member m WHERE m.id = ?1",nativeQuery = true)
    String deleteMemberById(@Param("id")Long id);

}
