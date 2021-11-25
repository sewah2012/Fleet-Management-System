package com.emmanueltech.springbootcompleteapplication.repositories;

import com.emmanueltech.springbootcompleteapplication.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    Users findByUsername(String username);
}
