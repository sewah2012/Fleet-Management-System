package com.emmanueltech.springbootcompleteapplication.services;

import com.emmanueltech.springbootcompleteapplication.models.Country;
import com.emmanueltech.springbootcompleteapplication.models.Client;
import com.emmanueltech.springbootcompleteapplication.models.State;
import com.emmanueltech.springbootcompleteapplication.repositories.CountryRepository;
import com.emmanueltech.springbootcompleteapplication.repositories.ClientRepository;
import com.emmanueltech.springbootcompleteapplication.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }
    public List<State> getStates(){
        return stateRepository.findAll();
    }

    public List<Client> getClient(){
        return clientRepository.findAll();
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public Optional<Client> getSingleClient(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client;

    }



    public void deleteClient(Integer id){
        clientRepository.deleteById(id);
    }
}
