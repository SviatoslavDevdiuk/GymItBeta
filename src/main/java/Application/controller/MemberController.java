package Application.controller;
//

import Application.dao.MemberRepository;
import Application.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {
    List<Member> members = new ArrayList<>();
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

    @RequestMapping("/getMemberById")
    public ModelAndView getMemberById(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("showMember");
        Member member = repository.findById(id).orElse(new Member());
        mv.addObject(member);
        return mv;
    }

    @RequestMapping("/getMemberByName")
    public ModelAndView getMemberByFirstName(@RequestParam String fistName){
        ModelAndView mv = new ModelAndView("showMember");
        members = repository.findByFirstNameEndsWith(fistName);
        mv.addObject(members);
        return mv;

    }

//    public ModelAndView findByFirstName(@RequestParam String firstName) {
//        ModelAndView mv = new ModelAndView("showMember");
//        members = repository.findByFirstName(firstName);
//        mv.addObject(members);
//        return mv;
//    }
}
