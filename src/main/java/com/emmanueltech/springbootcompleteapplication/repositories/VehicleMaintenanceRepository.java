package com.emmanueltech.springbootcompleteapplication.repositories;

import com.emmanueltech.springbootcompleteapplication.models.VehicleMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMaintenanceRepository extends JpaRepository<VehicleMaintenance,Integer> {
}
