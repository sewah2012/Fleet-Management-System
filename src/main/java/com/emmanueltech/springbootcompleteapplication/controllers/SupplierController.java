package com.emmanueltech.springbootcompleteapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplierController {
    @GetMapping("/supplier")

    String getIndex(){
        return "supplier";
    }
}
