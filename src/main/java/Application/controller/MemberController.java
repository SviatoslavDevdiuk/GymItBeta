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

    @RequestMapping("/members")
    @ResponseBody
    public String getMembers(){
        return repository.findAll().toString();
    }

    @RequestMapping("/getMembersByName")
    public ModelAndView getMembersByFirstName(@RequestParam String firstName){

        List<Member> memberList = new ArrayList<>();
        ModelAndView mv = new ModelAndView("showMembers.html");
        memberList = repository.findByFirstNameEndsWith(firstName);
        mv.addObject(memberList);
        return mv;

    }

//    public ModelAndView findByFirstName(@RequestParam String firstName) {
//        ModelAndView mv = new ModelAndView("showMember");
//        members = repository.findByFirstName(firstName);
//        mv.addObject(members);
//        return mv;
//    }
}
