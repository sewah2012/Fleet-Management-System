package com.emmanueltech.springbootcompleteapplication.services;

import com.emmanueltech.springbootcompleteapplication.models.Country;
import com.emmanueltech.springbootcompleteapplication.models.Location;
import com.emmanueltech.springbootcompleteapplication.models.State;
import com.emmanueltech.springbootcompleteapplication.repositories.CountryRepository;
import com.emmanueltech.springbootcompleteapplication.repositories.LocationRepository;
import com.emmanueltech.springbootcompleteapplication.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private LocationRepository locationRepository;

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }
    public List<State> getStates(){
        return stateRepository.findAll();
    }

    public List<Location> getLocation(){
        return locationRepository.findAll();
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public Optional<Location> getSingleLocation(Integer id) {
        Optional<Location> location = locationRepository.findById(id);
        return location;

    }



    public void deleteLocation(Integer id){
        locationRepository.deleteById(id);
    }
}
