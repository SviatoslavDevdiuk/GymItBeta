package application.controller;

import application.repository.MemberRepository;
import application.repository.UserRepository;
import application.model.Member;
import application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


//@RequestMapping(value = "/admin")
@Controller
public class AdminController {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    //    @PreAuthorize("ADMIN")
    @PostMapping(value = "/admin/add")
    public String addUserByAdmin(@RequestBody User user) {
        String password = user.getPassword();
        String encryptPassword = passwordEncoder.encode(password);
        user.setPassword(encryptPassword);
        userRepository.save(user);
        return "User has been added";

    }

    @RequestMapping("add-member")
    public String addMember() {
        return "newMemberForm";
    }

    @PostMapping("/register-member")
    @ResponseBody
    public String addMember(Member member) {
        memberRepository.save(member);
        return "member has been added successfully";
    }

    @RequestMapping("/edit-member/")
    public String editForm() {

        return "editMember";
    }

    @PostMapping("/edit-member-processing")
    @ResponseBody
    public String editMember(@RequestParam Long id, Member newMember) {
        Member member = getMemberById(id);
        member.setFirstName(newMember.getFirstName());
        member.setLastName(newMember.getLastName());
        member.setEmail(newMember.getEmail());
        member.setContactNumber(newMember.getContactNumber());
        memberRepository.save(member);
        return "Member " + member.getFirstName() + " " + member.getLastName() + " info has been updated successfully";
    }

    @PostMapping("/member")
    public Member addMemberByPost(@RequestBody Member member) {
        memberRepository.save(member);
        return member;
    }

    @GetMapping("/member/{id}")
    @ResponseBody
    public Member getMemberById(@PathVariable("id") @RequestParam Long id) {
        return memberRepository.findById(id).get();
//    public ModelAndView getMemberById(@RequestParam Long id) {
//        ModelAndView mv = new ModelAndView("showMember");
//        Member member = memberRepository.findById(id).orElse(new Member());
//        mv.addObject(member);
//        return mv;
    }

    @GetMapping(value = "/delete-member/{id}")
    @ResponseBody
    public String deleteMemberById(@PathVariable("id") @RequestParam Long id) {
        Member m = memberRepository.findById(id).get();
        memberRepository.delete(m);
        return "member " + m.getFirstName() + " " + m.getLastName() + " has been deleted successfully";
    }
//    public String deleteMember(@PathVariable Long id) {
//        Member m = memberRepository.getOne(id);
//        memberRepository.deleteMemberById(m);

    @RequestMapping(value = "/members")
    @ResponseBody
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @GetMapping("/getMembersByName")
    @ResponseBody
    public ModelAndView getMembersByFirstName(@RequestParam String firstName) {

        List<Member> memberList = new ArrayList<>();
        ModelAndView mv = new ModelAndView("showMembers");
        memberList = memberRepository.findByFirstNameEndsWith(firstName);
        mv.addObject(memberList);
        return mv;

    }

//    public ModelAndView findByFirstName(@RequestParam String firstName) {
//        ModelAndView mv = new ModelAndView("showMember");
//        members = memberRepository.findByFirstName(firstName);
//        mv.addObject(members);
//        return mv;
//    }
}

