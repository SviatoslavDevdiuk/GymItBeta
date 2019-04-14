package application.service;

import application.model.Member;
import application.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> findByFirstNameEndsWith(String firstName) {
        return memberRepository.findByFirstNameEndsWith(firstName);
    }

    @Override
    public String deleteMemberById(Long id) {
        return memberRepository.deleteMemberById(id);
    }

    @Override
    public String save(Member member) {
        memberRepository.save(member);
        return "member has been added successfully";
    }
}
