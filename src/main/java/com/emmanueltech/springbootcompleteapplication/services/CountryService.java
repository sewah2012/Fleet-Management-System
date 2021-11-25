package com.emmanueltech.springbootcompleteapplication.services;

import com.emmanueltech.springbootcompleteapplication.models.Country;
import com.emmanueltech.springbootcompleteapplication.repositories.CountryRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    public void addCountry(Country country) {
         countryRepository.save(country);
    }

    public Optional<Country> getSingleCountry(Integer id) {
          Optional<Country> country = countryRepository.findById(id);
          return country;

    }

    public void editCountry(Country country) throws NotFoundException {
        Country country1 = countryRepository.findById(country.getId())
                .orElseThrow(()-> new NotFoundException("This country is not found"));

        country1.setId(country.getId());
        country1.setNationality(country.getNationality());
        country1.setDescription(country.getDescription());
        country1.setContinent(country.getContinent());
        country1.setCode(country.getCode());
        country1.setCapital(country.getCapital());

        countryRepository.save(country1);
    }

    public void deleteCountry(Integer id){
        countryRepository.deleteById(id);
    }

}
