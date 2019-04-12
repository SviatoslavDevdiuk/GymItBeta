package application.controller;

import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserRepository admrepo;

    @RequestMapping("/login")
    public String showLoginForm() {
        return "loginForm.html";
    }

    @RequestMapping("/")
//    @ResponseBody
    public String showHomePage(){
        return "home.html";
    }


//    @GetMapping("/home")
//    @ResponseBody
//    public ModelAndView greetingsForAdministrator(@RequestParam String userName){
//        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("userName",userName);
//        return modelAndView;
//    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView verifyLogin(@RequestParam String userName, @RequestParam String password) {
//        User admin = admrepo.findUserByNameAndPassword(userName,password);
//        if (admin!=null){
//            return greetingsForAdministrator(admin.getUserName());
//        }else return null;
//
//    }
}
