package Application.controller;

import Application.dao.MemberRepository;
import Application.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

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
    @RequestMapping("/getMember")
    public ModelAndView getMember(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("showMember");
        Member member = repository.findById(id).orElse(new Member());
        mv.addObject(member);
        return mv;
    }
}
