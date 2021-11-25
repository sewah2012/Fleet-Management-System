package com.emmanueltech.springbootcompleteapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMaintenanceController {
    @GetMapping("/vehicle_maintenance")

    String getIndex(){
        return "vehicle_maintenance";
    }
}
