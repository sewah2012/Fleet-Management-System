package com.emmanueltech.springbootcompleteapplication.services;

import com.emmanueltech.springbootcompleteapplication.models.VehicleStatus;
import com.emmanueltech.springbootcompleteapplication.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {
    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;


    public List<VehicleStatus> getVehicleStatus(){
        return vehicleStatusRepository.findAll();
    }

    public void addVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    public Optional<VehicleStatus> getSingleVehicleStatus(Integer id) {
        Optional<VehicleStatus> VehicleStatus = vehicleStatusRepository.findById(id);
        return VehicleStatus;

    }



    public void deleteVehicleStatus(Integer id){
        vehicleStatusRepository.deleteById(id);
    }
}
