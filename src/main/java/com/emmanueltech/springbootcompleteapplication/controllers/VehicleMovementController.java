package com.emmanueltech.springbootcompleteapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMovementController {
    @GetMapping("/vehicle_movement")

    String getIndex(){
        return "vehicle_movement";
    }
}
