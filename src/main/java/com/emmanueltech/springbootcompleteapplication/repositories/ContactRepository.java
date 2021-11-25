package com.emmanueltech.springbootcompleteapplication.repositories;

import com.emmanueltech.springbootcompleteapplication.models.Client;
import com.emmanueltech.springbootcompleteapplication.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
