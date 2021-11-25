package com.emmanueltech.springbootcompleteapplication.services;

import com.emmanueltech.springbootcompleteapplication.models.Country;
import com.emmanueltech.springbootcompleteapplication.models.State;
import com.emmanueltech.springbootcompleteapplication.repositories.CountryRepository;
import com.emmanueltech.springbootcompleteapplication.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;
    public List<Country> getCountries(){
        return countryRepository.findAll();
    }
    public List<State> getStates(){
        return stateRepository.findAll();
    }

    public void addState(State state) {
        stateRepository.save(state);
    }

    public Optional<State> getSingleState(Integer id) {
        Optional<State> State = stateRepository.findById(id);
        return State;

    }



    public void deleteState(Integer id){
        stateRepository.deleteById(id);
    }
}
