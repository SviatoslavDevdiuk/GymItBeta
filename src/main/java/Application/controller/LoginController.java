package Application.controller;

import Application.dao.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    AdministratorRepository admrepo;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)

    public String verifyLogin(@RequestParam String userName, @RequestParam String password) {
        if (admrepo.findAdministratorByNameAndPassword(userName,password)!=null){
            return "home";
        }else return "login";

    }
}
