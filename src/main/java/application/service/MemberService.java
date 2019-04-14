package application.service;

import application.model.Member;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberService {
    List<Member> findByFirstNameEndsWith(String firstName);

    String deleteMemberById(Long id);

    String save(Member member);
}
