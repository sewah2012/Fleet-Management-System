package com.emmanueltech.springbootcompleteapplication.repositories;

import com.emmanueltech.springbootcompleteapplication.models.Client;
import com.emmanueltech.springbootcompleteapplication.models.VehicleMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMovementRepository extends JpaRepository<VehicleMovement,Integer> {
}
