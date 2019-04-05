package Application.controller;

import Application.dao.MemberRepository;
import Application.dao.UserRepository;
import Application.model.Member;
import Application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


//@RequestMapping(value = "/admin")
@RestController
@RequestMapping("/secure/test")
public class AdminController {
    @Autowired
    private MemberRepository repository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

//    @PreAuthorize("ADMIN")
    @PostMapping("/admin/add")
    public String addUserByAdmin(@RequestBody User user) {
        String password = user.getPassword();
        String encryptPassword = passwordEncoder.encode(password);
        user.setPassword(encryptPassword);
        userRepository.save(user);
        return "User has been added";

    }

    @PostMapping("/add-member")
    public String addMember(Member member) {
        repository.save(member);
        return "home";
    }

    @RequestMapping("/edit-member/")
    public String editForm() {

        return "editMember";
    }

    @PostMapping(value = "/edit-member-processing")
    @ResponseBody
    public String editMember(@RequestParam Long id, String firstName, String lastName, int contactNumber, String email) {
        Member member = getMemberById(id);
        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setContactNumber(contactNumber);
        member.setEmail(email);
        repository.save(member);
        return "Member " + member.firstName + " " + member.getLastName() + " info has been updated successfully";
    }

    @PostMapping("/member")
    public Member addMemberByPost(@RequestBody Member member) {
        repository.save(member);
        return member;
    }

    @GetMapping("/member/{id}")
    @ResponseBody
    public Member getMemberById(@PathVariable("id") @RequestParam Long id) {
        return repository.findById(id).get();
//    public ModelAndView getMemberById(@RequestParam Long id) {
//        ModelAndView mv = new ModelAndView("showMember");
//        Member member = repository.findById(id).orElse(new Member());
//        mv.addObject(member);
//        return mv;
    }

    @GetMapping(value = "/delete-member/{id}")
    @ResponseBody
    public String deleteMemberById(@PathVariable("id") @RequestParam Long id) {
        Member m = repository.findById(id).get();
        repository.delete(m);
        return "member " + m.firstName + " " + m.getLastName() + " has been deleted successfully";
    }
//    public String deleteMember(@PathVariable Long id) {
//        Member m = repository.getOne(id);
//        repository.deleteMemberById(m);

    @RequestMapping(value = "/members")
    @ResponseBody
    public List<Member> getMembers() {
        return repository.findAll();
    }

    @GetMapping("/getMembersByName")
    @ResponseBody
    public ModelAndView getMembersByFirstName(@RequestParam String firstName) {

        List<Member> memberList = new ArrayList<>();
        ModelAndView mv = new ModelAndView("showMembers");
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

