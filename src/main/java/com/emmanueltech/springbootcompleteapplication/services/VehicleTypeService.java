package com.emmanueltech.springbootcompleteapplication.services;

import com.emmanueltech.springbootcompleteapplication.models.VehicleType;
import com.emmanueltech.springbootcompleteapplication.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;


    public List<VehicleType> getVehicleTypes(){
        return vehicleTypeRepository.findAll();
    }

    public void addVehicleType(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    public Optional<VehicleType> getSingleVehicleType(Integer id) {
        Optional<VehicleType> VehicleType = vehicleTypeRepository.findById(id);
        return VehicleType;

    }



    public void deleteVehicleType(Integer id){
        vehicleTypeRepository.deleteById(id);
    }
}
