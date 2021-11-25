package com.emmanueltech.springbootcompleteapplication.controllers;

import com.emmanueltech.springbootcompleteapplication.models.Country;
import com.emmanueltech.springbootcompleteapplication.services.CountryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping("/country")
    public String getCountry(Model model){
      List<Country> countryList = countryService.getCountries();
      model.addAttribute("countries",countryList);
      return "country";
    }

    @GetMapping("/country/find")
    @ResponseBody
    public Optional<Country> getSingleCountry(@PathParam("id") Integer id){
       Optional<Country> country = countryService.getSingleCountry(id);
       return country;
    }


    @PostMapping("/country/add_country")
    public String addCountry(Country country){
        countryService.addCountry(country);
        return "redirect:/country";
    }

    @RequestMapping(value = "/country/edit_country",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editCountry(Country country) throws NotFoundException {
        countryService.editCountry(country);
        return "redirect:/country";
    }

    @RequestMapping(value = "/country/delete_country",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteCountry(Integer id){
        countryService.deleteCountry(id);
        return "redirect:/country";
    }

}
