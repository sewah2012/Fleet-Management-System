package com.emmanueltech.springbootcompleteapplication.controllers;

import com.emmanueltech.springbootcompleteapplication.models.VehicleType;
import com.emmanueltech.springbootcompleteapplication.services.VehicleTypeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {
    @Autowired
    VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicle_type")
    public String getVehicleType(Model model){
        List<VehicleType> vehicle_type = vehicleTypeService.getVehicleTypes();
        model.addAttribute("vehicleTypes",vehicle_type);

        return "vehicle_type";
    }

    @GetMapping("/vehicle_type/find")
    @ResponseBody
    public Optional<VehicleType> getSingleVehicleType(@PathParam("id") Integer id){
        Optional<VehicleType> vehicle_type = vehicleTypeService.getSingleVehicleType(id);
        return vehicle_type;
    }


    @PostMapping("/vehicle_type/add_vehicle_type")
    public String addVehicleType(VehicleType vehicle_type){
        vehicleTypeService.addVehicleType(vehicle_type);
        return "redirect:/vehicle_type";
    }

    @RequestMapping(value = "/vehicle_type/edit_vehicle_type",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editVehicleType(VehicleType VehicleType) throws NotFoundException {
        vehicleTypeService.addVehicleType(VehicleType);
        return "redirect:/vehicle_type";
    }

    @RequestMapping(value = "/vehicle_type/delete_vehicle_type",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteVehicleType(Integer id){
        vehicleTypeService.deleteVehicleType(id);
        return "redirect:/vehicle_type";
    }
}
