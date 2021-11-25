package com.emmanueltech.springbootcompleteapplication.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class VehicleHireController {
    @GetMapping("/vehicle_hire")

    String getIndex(){
        return "vehicle_hire";
    }
}
