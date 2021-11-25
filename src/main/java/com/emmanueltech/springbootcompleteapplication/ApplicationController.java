package com.emmanueltech.springbootcompleteapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    @GetMapping("/index")
    String getIndex(){
        return "index";
    }

    @GetMapping("/login")
    String getLogin(){return "login";}

    @GetMapping("logout")
    String getLogout(){return "login";}

}
