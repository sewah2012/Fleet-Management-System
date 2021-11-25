package com.emmanueltech.springbootcompleteapplication.services;

import com.emmanueltech.springbootcompleteapplication.models.VehicleModel;
import com.emmanueltech.springbootcompleteapplication.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;


    public List<VehicleModel> getVehicleModels(){
        return vehicleModelRepository.findAll();
    }

    public void addVehicleModel(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    public Optional<VehicleModel> getSingleVehicleModel(Integer id) {
        Optional<VehicleModel> VehicleModel = vehicleModelRepository.findById(id);
        return VehicleModel;

    }



    public void deleteVehicleModel(Integer id){
        vehicleModelRepository.deleteById(id);
    }
}
