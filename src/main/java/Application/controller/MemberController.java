package Application.controller;

import Application.dao.MemberRepository;
import Application.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {
    @Autowired
    MemberRepository repository;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/addMember")
    public String addMember(Member member) {
        repository.save(member);
        return "home";
    }
}
