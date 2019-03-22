package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {
    @RequestMapping(value = "/home")
    public String home(){
        return "home";
    }
}
