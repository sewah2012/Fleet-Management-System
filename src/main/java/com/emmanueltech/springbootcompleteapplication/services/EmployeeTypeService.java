package com.emmanueltech.springbootcompleteapplication.services;

import com.emmanueltech.springbootcompleteapplication.models.Country;
import com.emmanueltech.springbootcompleteapplication.models.EmployeeType;
import com.emmanueltech.springbootcompleteapplication.repositories.CountryRepository;
import com.emmanueltech.springbootcompleteapplication.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;


    public List<EmployeeType> getEmployeeTypes(){
        return employeeTypeRepository.findAll();
    }

    public void addEmployeeType(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    public Optional<EmployeeType> getSingleEmployeeType(Integer id) {
        Optional<EmployeeType> EmployeeType = employeeTypeRepository.findById(id);
        return EmployeeType;

    }



    public void deleteEmployeeType(Integer id){
        employeeTypeRepository.deleteById(id);
    }
}
