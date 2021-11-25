package com.emmanueltech.springbootcompleteapplication.controllers;

import com.emmanueltech.springbootcompleteapplication.models.Country;
import com.emmanueltech.springbootcompleteapplication.models.Location;
import com.emmanueltech.springbootcompleteapplication.models.State;
import com.emmanueltech.springbootcompleteapplication.services.CountryService;
import com.emmanueltech.springbootcompleteapplication.services.LocationService;
import com.emmanueltech.springbootcompleteapplication.services.StateService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {
    @Autowired
    LocationService locationService;

    @Autowired
    StateService stateService;

    @Autowired
    CountryService countryService;

    @GetMapping("/location")
    public String getLocation(Model model){
        List<Location> locationList = locationService.getLocation();
        model.addAttribute("locations",locationList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states",stateList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries",countryList);

        return "location";
    }

    @GetMapping("/location/find")
    @ResponseBody
    public Optional<Location> getSingleLocation(@PathParam("id") Integer id){
        Optional<Location> location = locationService.getSingleLocation(id);
        return location;
    }


    @PostMapping("/location/add_location")
    public String addLocation(Location location){
        locationService.addLocation(location);
        return "redirect:/location";
    }

    @RequestMapping(value = "/location/edit_location",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editLocation(Location Location) throws NotFoundException {
        locationService.addLocation(Location);
        return "redirect:/location";
    }

    @RequestMapping(value = "/location/delete_location",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteLocation(Integer id){
        locationService.deleteLocation(id);
        return "redirect:/location";
    }
}
