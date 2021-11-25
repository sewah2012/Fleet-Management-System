package com.emmanueltech.springbootcompleteapplication.controllers;

import com.emmanueltech.springbootcompleteapplication.models.VehicleMake;
import com.emmanueltech.springbootcompleteapplication.services.VehicleMakeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {
    @Autowired
    VehicleMakeService vehicleMakeService;

    @GetMapping("/vehicle_make")
    public String getVehicleMake(Model model){
        List<VehicleMake> vehicleMake = vehicleMakeService.getVehicleMakes();
        model.addAttribute("vehicleMake",vehicleMake);

        return "vehicle_make";
    }

    @GetMapping("/vehicle_make/find")
    @ResponseBody
    public Optional<VehicleMake> getSingleVehicleMake(@PathParam("id") Integer id){
        Optional<VehicleMake> vehicle_make = vehicleMakeService.getSingleVehicleMake(id);
        return vehicle_make;
    }


    @PostMapping("/vehicle_make/add_vehicle_make")
    public String addVehicleMake(VehicleMake vehicle_make){
        vehicleMakeService.addVehicleMake(vehicle_make);
        return "redirect:/vehicle_make";
    }

    @RequestMapping(value = "/vehicle_make/edit_vehicle_make",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editVehicleMake(VehicleMake VehicleMake) throws NotFoundException {
        vehicleMakeService.addVehicleMake(VehicleMake);
        return "redirect:/vehicle_make";
    }

    @RequestMapping(value = "/vehicle_make/delete_vehicle_make",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteVehicleMake(Integer id){
        vehicleMakeService.deleteVehicleMake(id);
        return "redirect:/vehicle_make";
    }
}
