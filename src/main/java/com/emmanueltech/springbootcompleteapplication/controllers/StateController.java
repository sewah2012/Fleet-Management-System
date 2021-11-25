package com.emmanueltech.springbootcompleteapplication.controllers;

import com.emmanueltech.springbootcompleteapplication.models.Country;
import com.emmanueltech.springbootcompleteapplication.models.State;
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
public class StateController {

    @Autowired
    StateService stateService;

    @GetMapping("/state")
    public String getState(Model model){
        List<State> stateList = stateService.getStates();
        model.addAttribute("states",stateList);

        List<Country> countryList = stateService.getCountries();
        model.addAttribute("countries",countryList);
        return "state";
    }

    @GetMapping("/state/find")
    @ResponseBody
    public Optional<State> getSingleState(@PathParam("id") Integer id){
        Optional<State> state = stateService.getSingleState(id);
        return state;
    }


    @PostMapping("/state/add_state")
    public String addState(State state){
        stateService.addState(state);
        return "redirect:/state";
    }

    @RequestMapping(value = "/state/edit_state",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editState(State State) throws NotFoundException {
        stateService.addState(State);
        return "redirect:/state";
    }

    @RequestMapping(value = "/state/delete_state",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteState(Integer id){
        stateService.deleteState(id);
        return "redirect:/state";
    }
}
