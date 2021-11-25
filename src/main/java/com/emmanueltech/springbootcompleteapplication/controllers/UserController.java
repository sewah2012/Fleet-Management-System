package com.emmanueltech.springbootcompleteapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/user")

    String getIndex(){
        return "user";
    }
}
