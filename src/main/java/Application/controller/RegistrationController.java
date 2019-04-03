package Application.controller;

import Application.dao.AdministratorRepository;
import Application.dao.RegistrationRepository;
import Application.model.Administrator;
import Application.model.RegistrationAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {
    @Autowired
    RegistrationRepository regrepo;
    @Autowired
    AdministratorRepository adminrepo;
    @RequestMapping(value = "/registration-form")
    public String createANewAccount(){
        return "registrationForm";
    }

    public RegistrationAccess findRegistrationKey(String key) {
        return regrepo.findRegistrationKey(key);
    }

    @RequestMapping(value = "/register-new-administrator")
    @ResponseBody
    public String registerAdmin(String registrationKey, Administrator administrator) {
        if (findRegistrationKey(registrationKey) != null) {
            adminrepo.save(administrator);
            return "The new administrator has been successfully added!";
        } else return "the key does not exists";

    }

}
