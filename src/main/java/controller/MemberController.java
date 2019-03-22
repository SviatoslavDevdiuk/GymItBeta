package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(){
        return "home";
    }
}
