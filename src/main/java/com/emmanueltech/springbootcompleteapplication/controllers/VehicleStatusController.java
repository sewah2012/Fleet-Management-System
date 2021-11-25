package com.emmanueltech.springbootcompleteapplication.controllers;

import com.emmanueltech.springbootcompleteapplication.models.VehicleStatus;
import com.emmanueltech.springbootcompleteapplication.services.VehicleStatusService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {
    @Autowired
    VehicleStatusService vehicleStatusService;

    @GetMapping("/vehicle_status")
    public String getVehicleStatus(Model model){
        List<VehicleStatus> vehicleStatus = vehicleStatusService.getVehicleStatus();
        model.addAttribute("vehicleStatus",vehicleStatus);

        return "vehicle_status";
    }

    @GetMapping("/vehicle_status/find")
    @ResponseBody
    public Optional<VehicleStatus> getSingleVehicleStatus(@PathParam("id") Integer id){
        Optional<VehicleStatus> vehicle_status = vehicleStatusService.getSingleVehicleStatus(id);
        return vehicle_status;
    }


    @PostMapping("/vehicle_status/add_vehicle_status")
    public String addVehicleStatus(VehicleStatus vehicle_status){
        vehicleStatusService.addVehicleStatus(vehicle_status);
        return "redirect:/vehicle_status";
    }

    @RequestMapping(value = "/vehicle_status/edit_vehicle_status",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editVehicleStatus(VehicleStatus VehicleStatus) throws NotFoundException {
        vehicleStatusService.addVehicleStatus(VehicleStatus);
        return "redirect:/vehicle_status";
    }

    @RequestMapping(value = "/vehicle_status/delete_vehicle_status",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteVehicleStatus(Integer id){
        vehicleStatusService.deleteVehicleStatus(id);
        return "redirect:/vehicle_status";
    }
}
