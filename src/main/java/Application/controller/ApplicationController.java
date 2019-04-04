package Application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth/")
public class ApplicationController {

     @GetMapping("/process")
     @ResponseBody
    public String process(){
         return "in process...";

     }
}
