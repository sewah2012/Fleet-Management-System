package com.emmanueltech.springbootcompleteapplication.controllers;

import com.emmanueltech.springbootcompleteapplication.models.VehicleModel;
import com.emmanueltech.springbootcompleteapplication.services.VehicleModelService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {
    @Autowired
    VehicleModelService vehicleModelService;

    @GetMapping("/vehicle_model")
    public String getVehicleModel(Model model){
        List<VehicleModel> vehicleModel = vehicleModelService.getVehicleModels();
        model.addAttribute("vehicleModel",vehicleModel);

        return "vehicle_model";
    }

    @GetMapping("/vehicle_model/find")
    @ResponseBody
    public Optional<VehicleModel> getSingleVehicleModel(@PathParam("id") Integer id){
        Optional<VehicleModel> vehicle_model = vehicleModelService.getSingleVehicleModel(id);
        return vehicle_model;
    }


    @PostMapping("/vehicle_model/add_vehicle_model")
    public String addVehicleModel(VehicleModel vehicle_model){
        vehicleModelService.addVehicleModel(vehicle_model);
        return "redirect:/vehicle_model";
    }

    @RequestMapping(value = "/vehicle_model/edit_vehicle_model",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editVehicleModel(VehicleModel VehicleModel) throws NotFoundException {
        vehicleModelService.addVehicleModel(VehicleModel);
        return "redirect:/vehicle_model";
    }

    @RequestMapping(value = "/vehicle_model/delete_vehicle_model",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteVehicleModel(Integer id){
        vehicleModelService.deleteVehicleModel(id);
        return "redirect:/vehicle_model";
    }
}
