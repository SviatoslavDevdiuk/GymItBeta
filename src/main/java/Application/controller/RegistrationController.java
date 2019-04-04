package Application.controller;

import Application.dao.UserRepository;
import Application.dao.RegistrationRepository;
import Application.model.User;
import Application.model.RegistrationAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {
    @Autowired
    RegistrationRepository regrepo;
    @Autowired
    UserRepository adminrepo;
    @RequestMapping(value = "/registration-form")
    public String createANewAccount(){
        return "registrationForm";
    }

    public RegistrationAccess findRegistrationKey(String key) {
        return regrepo.findRegistrationKey(key);
    }

    @RequestMapping(value = "/register-new-administrator",method = RequestMethod.POST)
    @ResponseBody
    public String registerAdmin(@RequestParam String registrationKey, User user) {
        if (findRegistrationKey(registrationKey) != null) {
            adminrepo.save(user);
            return "The new user has been successfully added!";
        } else return "the key does not exists";

    }

}
