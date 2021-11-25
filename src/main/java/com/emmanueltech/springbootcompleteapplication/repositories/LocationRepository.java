package com.emmanueltech.springbootcompleteapplication.repositories;

import com.emmanueltech.springbootcompleteapplication.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {
}
