package com.emmanueltech.springbootcompleteapplication.services;

import com.emmanueltech.springbootcompleteapplication.models.VehicleMake;
import com.emmanueltech.springbootcompleteapplication.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {
    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;


    public List<VehicleMake> getVehicleMakes(){
        return vehicleMakeRepository.findAll();
    }

    public void addVehicleMake(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }

    public Optional<VehicleMake> getSingleVehicleMake(Integer id) {
        Optional<VehicleMake> VehicleMake = vehicleMakeRepository.findById(id);
        return VehicleMake;

    }



    public void deleteVehicleMake(Integer id){
        vehicleMakeRepository.deleteById(id);
    }
}
